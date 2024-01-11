package services.liftNotes.Users.controller.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    private String username;
    private String email;
    private String password;
    private Integer age;
    private Integer weight;
    private String height;


    public User(){}

}
