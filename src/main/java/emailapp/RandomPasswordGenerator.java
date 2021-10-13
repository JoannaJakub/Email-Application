package emailapp;

import emailapp.repository.EmailRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class RandomPasswordGenerator {
    public final EmailRepository emailRepository;

    public RandomPasswordGenerator(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public String generatePassword() {
        Random random = new Random();
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*(){}?";
        String allChars = upper + lower + numbers + specialChars;
        List<Character> letters = new ArrayList<Character>();
        for (char c: allChars.toCharArray())
            letters.add(c);
        Collections.shuffle(letters);
        String password = "";
        int maxLength = 20;
        int minLength = 9;
        for (int i = random.nextInt(maxLength - minLength) + minLength; i > 0; --i) {
            password += letters.get(random.nextInt(letters.size()));
        }
        return password;
    }

}
