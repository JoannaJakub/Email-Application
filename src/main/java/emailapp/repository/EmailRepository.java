package emailapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
