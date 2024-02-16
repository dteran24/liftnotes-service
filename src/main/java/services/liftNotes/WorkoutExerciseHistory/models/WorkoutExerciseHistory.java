package services.liftNotes.WorkoutExerciseHistory.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import services.liftNotes.WorkoutExercises.model.WorkoutExercise;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutExerciseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "workout_exercise_id", nullable = false)
    @JsonBackReference
    private WorkoutExercise workoutExercise;

    private int sets;
    private int reps;
    private int weight;

    private String creationDate;
}
