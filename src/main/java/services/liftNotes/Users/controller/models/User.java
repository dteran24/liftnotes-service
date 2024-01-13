package services.liftNotes.Users.controller.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import services.liftNotes.config.models.Role;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    private String name;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private Integer age;
    private Integer weight;
    private String height;


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;


    public User(){}

}
