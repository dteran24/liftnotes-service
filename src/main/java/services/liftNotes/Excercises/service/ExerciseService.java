package services.liftNotes.Excercises.service;

import services.liftNotes.Excercises.models.Exercise;

import java.util.List;

public interface ExerciseService {
    public Exercise saveExercise(Exercise exercise);
    public void deleteExercise(Integer exerciseID);
    public Exercise getExerciseByID(Integer exerciseID);
    public List<Exercise> getAllExercise();
}
