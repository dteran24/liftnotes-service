package services.liftNotes.config.exceptions;

public class AccountDoesNotExist extends Exception{
    public AccountDoesNotExist(){
        super();
    }
    public AccountDoesNotExist(String message){
        super(message);

    }
}
