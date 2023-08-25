package services.liftNotes.Workouts.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutHistory {
    private String date;
    private Integer weight;
    private Integer reps;
    private Integer sets;
    private String notes;

    public WorkoutHistory(Workout workout) {
        this.date = workout.getDate();
        this.weight = workout.getWeight();
        this.reps = workout.getReps();
        this.sets = workout.getSets();
        this.notes = workout.getNotes();
    }

}
