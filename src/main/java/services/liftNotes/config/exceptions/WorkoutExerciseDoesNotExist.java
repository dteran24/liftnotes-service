package services.liftNotes.config.exceptions;

public class WorkoutExerciseDoesNotExist extends Exception{
    public WorkoutExerciseDoesNotExist(){
        super();
    }
    public WorkoutExerciseDoesNotExist(String message){
        super(message);
    }
}
