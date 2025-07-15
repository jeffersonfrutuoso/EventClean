package frutuoso.java10x.EventClean.infra.exceptions;

public class NotFoundIdException extends RuntimeException{
    public NotFoundIdException(String message){
        super(message);
    }
}
