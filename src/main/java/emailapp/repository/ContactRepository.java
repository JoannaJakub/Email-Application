package emailapp.repository;

import emailapp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query( value ="SELECT * FROM contact p WHERE CONCAT(p.id, p.message, p.date) LIKE %?1%",
            nativeQuery = true)
     List<Contact> search(String keyword);
}
