package services.liftNotes.Excercises.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.liftNotes.Excercises.models.Exercise;
import services.liftNotes.Excercises.repository.ExerciseRepository;

@Service
public class ExerciseServiceImpl implements ExerciseService{
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public Exercise saveExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @Override
    public Exercise getExerciseByID(Integer exerciseID) {
        return exerciseRepository.findById(exerciseID).orElse(null);
    }
}
