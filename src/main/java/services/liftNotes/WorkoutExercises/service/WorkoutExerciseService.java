package services.liftNotes.WorkoutExercises.service;

import org.springframework.beans.factory.annotation.Autowired;
import services.liftNotes.WorkoutExercises.model.WorkoutExercise;
import services.liftNotes.WorkoutExercises.repository.WorkoutExerciseRepo;

public interface WorkoutExerciseService {
  public WorkoutExercise saveWorkoutExercise(WorkoutExercise workoutExercise);
}
