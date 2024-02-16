package services.liftNotes.WorkoutExercises.service;

import services.liftNotes.WorkoutExercises.model.WorkoutExercise;
import services.liftNotes.config.exceptions.AccountDoesNotExist;
import services.liftNotes.config.exceptions.WorkoutExerciseDoesNotExist;

import java.util.List;

public interface WorkoutExerciseService {
  public void saveWorkoutExercise(WorkoutExercise workoutExercise);
  public void removeWorkoutExercise(int exerciseID) throws WorkoutExerciseDoesNotExist;
  public void updateWorkoutExercise(int exerciseID, WorkoutExercise workoutExercise) throws WorkoutExerciseDoesNotExist;
  public List<WorkoutExercise> findAllWithExerciseAndWorkoutByUserId(int userID) throws AccountDoesNotExist;
  public WorkoutExercise getAllWorkoutDataById(int id) throws WorkoutExerciseDoesNotExist;;
}
