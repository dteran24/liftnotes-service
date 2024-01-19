package services.liftNotes.Workouts.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import services.liftNotes.config.models.ApplicationUser;

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
    private ApplicationUser user;

    private String date;
    private String duration;

    public Workout() {
    }
}
