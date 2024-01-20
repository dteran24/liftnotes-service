package services.liftNotes.config.exceptions;

public class UsernameAlreadyExists extends Exception{
    public UsernameAlreadyExists() {
        super();
    }
    public UsernameAlreadyExists(String message) {
        super(message);
    }
}
