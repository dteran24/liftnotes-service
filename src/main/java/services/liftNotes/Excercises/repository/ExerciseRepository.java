package services.liftNotes.Excercises.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import services.liftNotes.Excercises.models.Exercise;

import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
    Optional<Exercise> findByName(String exerciseName);
}
