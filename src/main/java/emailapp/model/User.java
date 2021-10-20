package emailapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Component
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Please enter your username.")
    @Column(nullable = false,  length = 45)
    private String username;
    @NotBlank(message = "Please enter your password.")
    @Column(nullable = false, length = 64)
    private String password;
    @NotEmpty(message = "Please enter your name.")
    @Column(name = "firstName", nullable = false, length = 20)
    private String firstName;
    @NotBlank(message = "Please enter your surname.")
    @Column(name = "lastName", nullable = false, length = 20)
    private String lastName;
    private boolean enabled;
    @ManyToMany(cascade ={CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> role;

}
