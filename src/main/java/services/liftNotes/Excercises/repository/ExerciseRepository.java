package services.liftNotes.Excercises.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import services.liftNotes.Excercises.models.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
}
