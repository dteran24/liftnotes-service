package services.liftNotes.WorkoutExercises.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.liftNotes.WorkoutExercises.model.WorkoutExercise;
import services.liftNotes.WorkoutExercises.repository.WorkoutExerciseRepo;

@Service
public class WorkoutExerciseImpl implements WorkoutExerciseService{

    @Autowired
    private WorkoutExerciseRepo workoutExerciseRepo;

    @Override
    public WorkoutExercise saveWorkoutExercise(WorkoutExercise workoutExercise) {
        return workoutExerciseRepo.save(workoutExercise);
    }
}
