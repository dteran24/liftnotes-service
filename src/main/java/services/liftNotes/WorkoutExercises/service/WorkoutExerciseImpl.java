package services.liftNotes.WorkoutExercises.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.liftNotes.Utils.GetDate;
import services.liftNotes.WorkoutExerciseHistory.models.WorkoutExerciseHistory;
import services.liftNotes.WorkoutExerciseHistory.repository.WorkoutExerciseHistoryRepo;
import services.liftNotes.WorkoutExercises.model.WorkoutExercise;
import services.liftNotes.WorkoutExercises.repository.WorkoutExerciseRepo;
import services.liftNotes.config.exceptions.AccountDoesNotExist;
import services.liftNotes.config.exceptions.WorkoutExerciseDoesNotExist;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutExerciseImpl implements WorkoutExerciseService{


    private final WorkoutExerciseRepo workoutExerciseRepo;
    private final WorkoutExerciseHistoryRepo workoutExerciseHistoryRepo;

    @Autowired
    public WorkoutExerciseImpl(WorkoutExerciseRepo workoutExerciseRepo, WorkoutExerciseHistoryRepo workoutExerciseHistoryRepo){
        this.workoutExerciseRepo = workoutExerciseRepo;
        this.workoutExerciseHistoryRepo = workoutExerciseHistoryRepo;
    }

    @Override
    public void saveWorkoutExercise(WorkoutExercise workoutExercise) {
        workoutExerciseRepo.save(workoutExercise);
    }

    @Override
    @Transactional
    public void updateWorkoutExercise(int exerciseID, WorkoutExercise userWorkoutExercise) throws WorkoutExerciseDoesNotExist {
        Optional<WorkoutExercise> workoutExerciseInRepo = workoutExerciseRepo.findById(exerciseID);

        if(workoutExerciseInRepo.isPresent()){
           WorkoutExercise originalWorkoutExercise = workoutExerciseInRepo.get();

           String dateForHistory;
           if(originalWorkoutExercise.getLastUpdated().equals("")){
               dateForHistory = originalWorkoutExercise.getCreationDate();
           }else{
               dateForHistory = originalWorkoutExercise.getLastUpdated();
           }
           WorkoutExerciseHistory historyEntry = new WorkoutExerciseHistory(originalWorkoutExercise.getId(),originalWorkoutExercise ,originalWorkoutExercise.getSets(), originalWorkoutExercise.getReps(), originalWorkoutExercise.getWeight(), dateForHistory);

            originalWorkoutExercise.setReps(userWorkoutExercise.getReps());
            originalWorkoutExercise.setSets(userWorkoutExercise.getSets());
            originalWorkoutExercise.setWeight(userWorkoutExercise.getWeight());
            originalWorkoutExercise.setLastUpdated(GetDate.currentDate());
            workoutExerciseHistoryRepo.save(historyEntry);
            workoutExerciseRepo.save(originalWorkoutExercise);

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
    public List<WorkoutExercise> findAllWithExerciseAndWorkoutByUserId(int userID) {
        return workoutExerciseRepo.findAllWithExerciseAndWorkoutByUserId(userID);
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
