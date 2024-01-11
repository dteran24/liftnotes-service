package services.liftNotes.Workouts.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.liftNotes.Workouts.models.Workout;
import services.liftNotes.Workouts.repository.WorkoutRepository;



@Service
public class WorkoutServiceImpl implements WorkoutsService{

    @Autowired
    private WorkoutRepository workoutRepository;

    @Override
    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    @Override
    public Workout getWorkoutByID(Integer workoutID) {
        return workoutRepository.findById(workoutID).orElse(null);
    }
}
