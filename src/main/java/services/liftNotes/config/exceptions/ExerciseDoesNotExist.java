package services.liftNotes.config.exceptions;

public class ExerciseDoesNotExist extends Exception{
    public ExerciseDoesNotExist(){
        super();
    }
    public ExerciseDoesNotExist(String message){
        super(message);
    }
}
