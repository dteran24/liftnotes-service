package services.liftNotes.WorkoutExercises.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import services.liftNotes.WorkoutExercises.model.WorkoutExercise;

import java.util.List;

@Repository
public interface WorkoutExerciseRepo extends JpaRepository<WorkoutExercise, Integer> {
    @Query("SELECT we FROM WorkoutExercise we JOIN FETCH we.exercise")
    List<WorkoutExercise> findAllWithExerciseAndWorkout();
}