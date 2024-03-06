package services.liftNotes.Excercises.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.liftNotes.Excercises.models.Exercise;
import services.liftNotes.Excercises.repository.ExerciseRepository;
import services.liftNotes.config.exceptions.ExerciseAlreadyExists;
import services.liftNotes.config.exceptions.ExerciseDoesNotExist;

import java.util.*;

@Service
public class ExerciseServiceImpl implements ExerciseService{
    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository exerciseRepository){
        super();
        this.exerciseRepository = exerciseRepository;

    }

    @Override
    public Exercise saveExercise(Exercise exercise) throws ExerciseAlreadyExists {

        Optional<Exercise> existingExercise = exerciseRepository.findByName(exercise.getName());
        if(existingExercise.isPresent()){
            throw new ExerciseAlreadyExists("Exercise already exists!");
        }

        return exerciseRepository.save(exercise);
    }

    @Override
    public void deleteExercise(Integer exerciseID) throws ExerciseDoesNotExist {
        Optional<Exercise> exercise = exerciseRepository.findById(exerciseID);
        if (exercise.isPresent()){
            exerciseRepository.deleteById(exerciseID);
        }else{
            throw new ExerciseDoesNotExist("Exercise does not exist! :" + exerciseID);
        }

    }

    @Override
    public Exercise getExerciseByID(Integer exerciseID) throws ExerciseDoesNotExist {
        Optional<Exercise> exercise = exerciseRepository.findById(exerciseID);
        if (exercise.isPresent()){
            return exercise.get();
        }else{
            throw new ExerciseDoesNotExist("Exercise does not exist! id:" + exerciseID);
        }
    }

    @Override
    public List<Exercise> getAllExercise() {
        List<Exercise> exerciseList = exerciseRepository.findAll();
        exerciseList.sort(Comparator.comparing(Exercise::getName));

        return exerciseList;
    }
}
