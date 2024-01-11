package services.liftNotes.Excercises.service;

import services.liftNotes.Excercises.models.Exercise;

public interface ExerciseService {
    public Exercise saveExercise(Exercise exercise);
    public Exercise getExerciseByID(Integer exerciseID);
}
