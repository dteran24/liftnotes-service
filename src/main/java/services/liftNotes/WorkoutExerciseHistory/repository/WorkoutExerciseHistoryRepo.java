package services.liftNotes.WorkoutExerciseHistory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import services.liftNotes.WorkoutExerciseHistory.models.WorkoutExerciseHistory;

import java.util.List;

@Repository
public interface WorkoutExerciseHistoryRepo extends JpaRepository<WorkoutExerciseHistory, Integer> {

    @Query("SELECT weh FROM WorkoutExerciseHistory weh " +
            "JOIN FETCH weh.workoutExercise we " +
            "JOIN FETCH we.exercise " +
            "WHERE we.user.id = :userId")
    List<WorkoutExerciseHistory> findHistoryByUserId(@Param("userId") int userId);

}
