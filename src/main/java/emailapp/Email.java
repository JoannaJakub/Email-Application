package emailapp;

@Entity
@Data
@Component
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private String firstName;
    private String lastName;
    private String departament;
    private int mailboxCapacity;
    private String alternateEmail;
}
