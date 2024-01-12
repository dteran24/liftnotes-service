package services.liftNotes.WorkoutExercises.service;

import services.liftNotes.WorkoutExercises.model.WorkoutExercise;

public interface WorkoutExerciseService {
  public WorkoutExercise saveWorkoutExercise(WorkoutExercise workoutExercise);
  public void removeWorkoutExercise(Integer exerciseID);
}
