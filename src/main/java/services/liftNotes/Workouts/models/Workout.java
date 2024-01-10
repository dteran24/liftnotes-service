package services.liftNotes.Workouts.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import services.liftNotes.Users.models.User;
import java.util.Date;


@Getter
@Setter
@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String date;
    private String duration;

    public Workout() {
    }
}
