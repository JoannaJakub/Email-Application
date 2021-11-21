package emailapp.repository;

import emailapp.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmailRepository extends JpaRepository<Email, Long> {
    Email findTopByOrderByIdDesc();
    Email findByGeneratedEmail(String GeneratedEmail);
}
