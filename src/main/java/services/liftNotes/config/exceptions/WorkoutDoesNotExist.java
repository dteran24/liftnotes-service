package services.liftNotes.config.exceptions;

public class WorkoutDoesNotExist extends Exception{
    public WorkoutDoesNotExist(){
        super();
    }
    public WorkoutDoesNotExist(String message){
        super(message);
    }
}
