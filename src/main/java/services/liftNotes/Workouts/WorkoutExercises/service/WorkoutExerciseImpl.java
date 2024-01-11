package services.liftNotes.Workouts.WorkoutExercises.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.liftNotes.Workouts.WorkoutExercises.model.WorkoutExercise;
import services.liftNotes.Workouts.WorkoutExercises.repository.WorkoutExerciseRepo;

@Service
public class WorkoutExerciseImpl implements WorkoutExerciseService{

    @Autowired
    private WorkoutExerciseRepo workoutExerciseRepo;

    @Override
    public WorkoutExercise saveWorkoutExercise(WorkoutExercise workoutExercise) {
        return workoutExerciseRepo.save(workoutExercise);
    }
}
