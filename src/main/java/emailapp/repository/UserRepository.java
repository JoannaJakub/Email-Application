package emailapp.repository;

import emailapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findLastUserById(Long Id);
    User findByResetPasswordToken(String token);
    User findByEmail(String email);


    @Query( value ="SELECT * FROM user p JOIN user_role u  ON p.id = u.user_id WHERE CONCAT(p.id, p.username, p.first_name, p.last_name, p.enabled, p.reset_password_token, p.email, p.password, u.role_id) LIKE %?1%",
            nativeQuery = true)
    List<User> search(String keyword);

}

