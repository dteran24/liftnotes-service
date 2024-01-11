package services.liftNotes.WorkoutExercises.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import services.liftNotes.Excercises.models.Exercise;
import services.liftNotes.Workouts.models.Workout;

@Getter
@Setter
@Entity
public class WorkoutExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    private int sets;
    private int reps;
    private int weight;
}
