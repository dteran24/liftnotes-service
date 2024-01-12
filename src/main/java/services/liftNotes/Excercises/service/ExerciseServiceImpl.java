package services.liftNotes.Excercises.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.liftNotes.Excercises.models.Exercise;
import services.liftNotes.Excercises.repository.ExerciseRepository;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService{
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public Exercise saveExercise(Exercise exercise) {
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
