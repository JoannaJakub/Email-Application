package emailapp.repository;

import emailapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findLastUserById(Long Id);
    User findByResetPasswordToken(String token);
    User findByEmail(String email);

}
