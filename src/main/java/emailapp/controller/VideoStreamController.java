package emailapp.controller;

import emailapp.model.User;
import emailapp.service.VideoStreamService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
public class VideoStreamController {

    private final VideoStreamService videoStreamService;

    public VideoStreamController(VideoStreamService videoStreamService) {
        this.videoStreamService = videoStreamService;
    }

    @GetMapping("/{fileType}/{fileName}")
    public Mono<ResponseEntity<byte[]>> streamVideo(@PathVariable("fileType") String fileType,
                                                    @PathVariable("fileName") String fileName) {
        return Mono.just(videoStreamService.prepareContent(fileName, fileType));
    }
}
