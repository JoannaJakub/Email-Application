package emailapp.repository;

import emailapp.model.Contact;
import emailapp.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactRepository extends JpaRepository<Contact, Long> {
}
