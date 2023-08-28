package services.liftNotes.Workouts.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Workout {

    private String id;
    private String genre;
    private String name;
    private int reps;
    private int weight;
    private int sets;
    private String notes;
    private String date;
    private List<WorkoutHistory> history;

    public void updateWorkout(Workout updatedWorkout) {
        this.name = updatedWorkout.name;
        this.reps = updatedWorkout.reps;
        this.weight = updatedWorkout.weight;
        this.sets = updatedWorkout.sets;
        this.notes = updatedWorkout.notes;
        this.date = updatedWorkout.date;
    }
}
