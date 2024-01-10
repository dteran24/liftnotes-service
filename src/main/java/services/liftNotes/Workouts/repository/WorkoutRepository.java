package services.liftNotes.Workouts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.liftNotes.Workouts.models.Workout;
@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Integer> {
}
