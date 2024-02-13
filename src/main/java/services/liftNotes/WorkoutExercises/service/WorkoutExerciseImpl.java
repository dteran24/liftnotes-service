package services.liftNotes.WorkoutExercises.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.liftNotes.Utils.GetDate;
import services.liftNotes.WorkoutExercises.model.WorkoutExercise;
import services.liftNotes.WorkoutExercises.repository.WorkoutExerciseRepo;
import services.liftNotes.config.exceptions.WorkoutExerciseDoesNotExist;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutExerciseImpl implements WorkoutExerciseService{

    @Autowired
    private WorkoutExerciseRepo workoutExerciseRepo;

    @Override
    public void saveWorkoutExercise(WorkoutExercise workoutExercise) {
        workoutExerciseRepo.save(workoutExercise);
    }

    @Override
    public void updateWorkoutExercise(int exerciseID, WorkoutExercise userWorkoutExercise) throws WorkoutExerciseDoesNotExist {
        Optional<WorkoutExercise> workoutExerciseInRepo = workoutExerciseRepo.findById(exerciseID);
        if(workoutExerciseInRepo.isPresent()){
           WorkoutExercise w = workoutExerciseInRepo.get();
           w.setReps(userWorkoutExercise.getReps());
           w.setSets(userWorkoutExercise.getSets());
           w.setWeight(userWorkoutExercise.getWeight());
           w.setLastUpdated(GetDate.currentDate());
           workoutExerciseRepo.save(w);

        }else{
            throw new WorkoutExerciseDoesNotExist("Workout exercise does not exist  ID: " + exerciseID);
        }
    }
    @Override
    public void removeWorkoutExercise(int exerciseID) throws WorkoutExerciseDoesNotExist {
        Optional<WorkoutExercise> workoutExercise = workoutExerciseRepo.findById(exerciseID);
            if(workoutExercise.isPresent()){
                workoutExerciseRepo.deleteById(exerciseID);
            }else{
                throw new WorkoutExerciseDoesNotExist("Workout exercise does not exist  ID: " + exerciseID);
            }
    }

    @Override
    public List<WorkoutExercise> getAllWorkoutData() {
        return workoutExerciseRepo.findAllWithExerciseAndWorkout();
    }

    @Override
    public WorkoutExercise getAllWorkoutDataById(int exerciseID) throws WorkoutExerciseDoesNotExist {
        Optional<WorkoutExercise> workoutExercise = workoutExerciseRepo.findById(exerciseID);
        if(workoutExercise.isPresent()){
            return workoutExerciseRepo.findAllWithExerciseAndWorkoutById(exerciseID);
        }else{
            throw new WorkoutExerciseDoesNotExist("Workout exercise does not exist  ID: " + exerciseID);
        }

    };


}
