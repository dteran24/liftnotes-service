package services.liftNotes.Workouts.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import services.liftNotes.Users.controller.models.User;



@Getter
@Setter
@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String date;
    private String duration;

    public Workout() {
    }
}
