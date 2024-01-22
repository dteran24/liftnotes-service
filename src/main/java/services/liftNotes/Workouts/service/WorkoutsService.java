package services.liftNotes.Workouts.service;

import services.liftNotes.Workouts.models.Workout;
import services.liftNotes.config.exceptions.WorkoutDoesNotExist;

public interface WorkoutsService {

    public void saveWorkout(Workout workout);
    public void deleteWorkout(int workoutID) throws WorkoutDoesNotExist;
    public Workout getWorkoutByID(int workoutID) throws WorkoutDoesNotExist;

}
