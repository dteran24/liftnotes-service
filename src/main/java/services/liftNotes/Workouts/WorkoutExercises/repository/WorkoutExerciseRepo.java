package services.liftNotes.Workouts.WorkoutExercises.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.liftNotes.Workouts.WorkoutExercises.model.WorkoutExercise;

@Repository
public interface WorkoutExerciseRepo extends JpaRepository<WorkoutExercise, Integer> {
}
