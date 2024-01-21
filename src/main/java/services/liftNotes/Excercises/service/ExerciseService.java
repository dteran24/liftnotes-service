package services.liftNotes.Excercises.service;

import services.liftNotes.Excercises.models.Exercise;
import services.liftNotes.config.exceptions.ExerciseAlreadyExists;
import services.liftNotes.config.exceptions.ExerciseDoesNotExist;

import java.util.List;

public interface ExerciseService {
    public Exercise saveExercise(Exercise exercise) throws ExerciseAlreadyExists;
    public void deleteExercise(Integer exerciseID) throws ExerciseDoesNotExist;
    public Exercise getExerciseByID(Integer exerciseID) throws ExerciseDoesNotExist;
    public List<Exercise> getAllExercise();
}
