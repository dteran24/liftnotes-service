package services.liftNotes.Workouts.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import services.liftNotes.Utils.RandomIdGenerator;
import services.liftNotes.Workouts.models.Workout;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class WorkoutList {
    private String genre;
    private List<Workout> workouts;

    // Method to add a workout
    public void addWorkout(Workout workout) {
        if (workout.getGenre().equals(this.genre)) {
            workouts.add(workout);
        }
    }


    public boolean updateWorkoutById(String id, Workout updatedWorkout) {
        for (Workout workout : workouts) {
            if (workout.getId() == id) {
                workout.updateWorkout(updatedWorkout);
                return true;
            }
        }
        return false;
    }
}


