package services.liftNotes.Excercises.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.liftNotes.Excercises.models.Exercise;
import services.liftNotes.Excercises.repository.ExerciseRepository;
import services.liftNotes.config.exceptions.ExerciseAlreadyExists;

import java.util.List;
import java.util.Optional;

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
    public void deleteExercise(Integer exerciseID) {
        exerciseRepository.deleteById(exerciseID);
    }

    @Override
    public Exercise getExerciseByID(Integer exerciseID) {
        return exerciseRepository.findById(exerciseID).orElse(null);
    }

    @Override
    public List<Exercise> getAllExercise() {
        return exerciseRepository.findAll();
    }
}
