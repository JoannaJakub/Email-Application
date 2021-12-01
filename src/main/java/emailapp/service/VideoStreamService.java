package emailapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import static emailapp.VideoConst.*;


@Service
public class VideoStreamService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public ResponseEntity<byte[]> prepareContent(String fileName, String fileType, String range) {
        long rangeStart = 0;
        long rangeEnd;
        byte[] data;
        Long fileSize;
        String fullFileName = fileName + "." + fileType;

        fileSize = getFileSize(fullFileName);
        if (range == null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .header(CONTENT_TYPE, VIDEO_CONTENT + fileType)
                    .header(CONTENT_LENGTH, String.valueOf(fileSize))
                    .body(readByteRange(fullFileName, rangeStart, fileSize - 1)); // Read the object and convert it as bytes
        }
        String[] ranges = range.split("-");
        rangeStart = Long.parseLong(ranges[0].substring(6));

        data = readByteRange(fullFileName, rangeStart, rangeEnd);

        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT);


    }

    public byte[] readByteRange(String filename, long start, long end) throws IOException {
        Path path = Paths.get(getFilePath(), filename);
        System.out.println(path);
        try (InputStream inputStream = (Files.newInputStream(path));
             ByteArrayOutputStream bufferedOutputStream = new ByteArrayOutputStream()) {
            byte[] data = new byte[BYTE_RANGE];
            int nRead;
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                bufferedOutputStream.write(data, 0, nRead);
            }
            bufferedOutputStream.flush();
            System.out.println(bufferedOutputStream);

            byte[] result = new byte[(int) (end - start) + 1];
            System.arraycopy(bufferedOutputStream.toByteArray(), (int) start, result, 0, result.length);
            System.out.println("START" + start);

            return result;
        }
    }

    private String getFilePath() {
        URL url = this.getClass().getResource(VIDEO);
        System.out.println(VIDEO);
        return new File(url.getFile()).getAbsolutePath();
    }

    public Long getFileSize(String fileName) {
        return Optional.ofNullable(fileName)
                .map(file -> Paths.get(getFilePath(), file))
                .map(this::sizeFromFile)
                .orElse(0L);
    }

    private Long sizeFromFile(Path path) {
        try {
            return Files.size(path);
        } catch (IOException ioException) {
            logger.error("Error while getting the file size", ioException);
        }
        return 0L;
    }
}
