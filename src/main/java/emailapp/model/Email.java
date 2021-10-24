package emailapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Component
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Please enter your username.")
    @Column(nullable = false,  length = 45)
    private String firstName;
    @NotEmpty(message = "Please enter your username.")
    @Column(nullable = false,  length = 45)
    private String lastName;
    private String password;
    private String generatedEmail;
    private int mailboxCapacity = 500;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "user_department", joinColumns = @JoinColumn(name = "email_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private Department department;
}
