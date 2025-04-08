package pe.example.springWeb.v01.exception;

public class RolNotFoundException extends GlobalException {

    public RolNotFoundException(String message) {
        super(message);
    }

    public RolNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
