package emailapp.repository;

import emailapp.model.Contact;
import emailapp.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EmailRepository extends JpaRepository<Email, Long> {
    Email findTopByOrderByIdDesc();
    Email findByGeneratedEmail(String GeneratedEmail);

    @Query( value ="SELECT DISTINCT * FROM email p JOIN user_department u  ON p.id = u.email_id WHERE CONCAT(p.id, p.first_name, p.last_name, p.password, p.generated_email, p.mailbox_capacity, u.department_id) LIKE %?1%",
            nativeQuery = true)
    List<Email> search(String keyword);
}
