package pe.example.springWeb.v01.exception;

public class InvalidProductIdException extends GlobalException {
    
    private static final long serialVersionUID = 1L;

    public InvalidProductIdException(String message) {
        super(message);
    }

    public InvalidProductIdException(String message, Throwable cause) {
        super(message, cause);
    }
}