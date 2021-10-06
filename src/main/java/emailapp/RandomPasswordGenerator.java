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
        Collections.shuffle(letters); // Inbuilt method to randomly shuffle a elements of a list
        String password = "";
        int maxLength = 20; // let consider max length is 20
        int minLength = 9; // let consider min length is 9
        for (int i = random.nextInt(maxLength - minLength) + minLength; i > 0; --i) {
            password += letters.get(random.nextInt(letters.size()));
        }

        System.out.print("Password: " + password); // The size of the password is random
        return password;
    }

}
