package services.liftNotes.WorkoutExerciseHistory.service;

import services.liftNotes.WorkoutExerciseHistory.models.WorkoutExerciseHistory;
import services.liftNotes.config.exceptions.AccountDoesNotExist;

import java.util.List;

public interface WorkoutExerciseHistoryService {
    public List<WorkoutExerciseHistory> getHistoryByUserId(int id) throws AccountDoesNotExist;
}
