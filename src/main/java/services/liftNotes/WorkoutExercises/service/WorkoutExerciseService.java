package services.liftNotes.WorkoutExercises.service;

import services.liftNotes.WorkoutExercises.model.WorkoutExercise;
import services.liftNotes.config.exceptions.WorkoutExerciseDoesNotExist;

import java.util.List;

public interface WorkoutExerciseService {
  public void saveWorkoutExercise(WorkoutExercise workoutExercise);
  public void removeWorkoutExercise(Integer exerciseID) throws WorkoutExerciseDoesNotExist;

  public List<WorkoutExercise> getAllWorkoutData();
}
