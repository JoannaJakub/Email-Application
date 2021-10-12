package emailapp.repository;

import emailapp.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmailRepository extends JpaRepository<Email, Long> {
    Email findTopByOrderByIdDesc();
}
