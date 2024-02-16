package services.liftNotes.WorkoutExerciseHistory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.liftNotes.WorkoutExerciseHistory.models.WorkoutExerciseHistory;
import services.liftNotes.WorkoutExerciseHistory.repository.WorkoutExerciseHistoryRepo;
import services.liftNotes.config.exceptions.AccountDoesNotExist;

import java.util.List;


@Service
public class WorkoutExerciseHistoryImpl implements WorkoutExerciseHistoryService{

    private final WorkoutExerciseHistoryRepo workoutExerciseHistoryRepo;

    @Autowired
    public WorkoutExerciseHistoryImpl(WorkoutExerciseHistoryRepo workoutExerciseHistoryRepo){
        this.workoutExerciseHistoryRepo = workoutExerciseHistoryRepo;
    }

    @Override
    public List<WorkoutExerciseHistory> getHistoryByUserId(int id) {

        return workoutExerciseHistoryRepo.findHistoryByUserId(id);
    }
}
