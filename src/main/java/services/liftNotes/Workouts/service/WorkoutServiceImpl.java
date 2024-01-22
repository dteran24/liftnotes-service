package services.liftNotes.Workouts.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.liftNotes.Workouts.models.Workout;
import services.liftNotes.Workouts.repository.WorkoutRepository;
import services.liftNotes.config.exceptions.WorkoutDoesNotExist;

import javax.swing.text.html.Option;
import java.util.Optional;


@Service
public class WorkoutServiceImpl implements WorkoutsService{

    private final WorkoutRepository workoutRepository;

    @Autowired
    WorkoutServiceImpl(WorkoutRepository workoutRepository){
        super();
        this.workoutRepository = workoutRepository;

    }

    @Override
    public void saveWorkout(Workout workout) {
        workoutRepository.save(workout);
    }

    @Override
    public void deleteWorkout(int workoutID) throws WorkoutDoesNotExist {
        Optional<Workout> workout = workoutRepository.findById(workoutID);
        if(workout.isPresent()){
            workoutRepository.delete(workout.get());
        }else{
            throw new WorkoutDoesNotExist("Workout does not exist with ID: " + workoutID);
        }
    }

    @Override
    public Workout getWorkoutByID(int workoutID) throws WorkoutDoesNotExist {
        return workoutRepository.findById(workoutID).orElseThrow(() -> new WorkoutDoesNotExist("Workout does not exist with ID: " + workoutID));
    }

}
