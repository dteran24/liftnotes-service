package services.liftNotes.config.exceptions;

public class ExerciseAlreadyExists extends Exception{
    public ExerciseAlreadyExists(){
        super();
    }
    public ExerciseAlreadyExists(String message){
        super(message);
    }
}
