package services.liftNotes.Workouts.service;

import services.liftNotes.Workouts.models.Workout;

public interface WorkoutsService {

    public Workout saveWorkout(Workout workout);
    public Workout getWorkoutByID(Integer workoutID);

}
