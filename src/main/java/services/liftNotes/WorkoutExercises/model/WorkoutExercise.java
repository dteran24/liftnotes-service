package services.liftNotes.WorkoutExercises.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import services.liftNotes.Excercises.models.Exercise;
import services.liftNotes.WorkoutExerciseHistory.models.WorkoutExerciseHistory;
import services.liftNotes.config.models.ApplicationUser;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class WorkoutExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_exercise_id")
    private int id;

//    @ManyToOne
//    @JoinColumn(name = "workout_id")
//    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private ApplicationUser user;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @OneToMany(mappedBy = "workoutExercise", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<WorkoutExerciseHistory> historyList = new ArrayList<>();

    private int sets;
    private int reps;
    private int weight;
    private String creationDate;
    private String lastUpdated;
}
