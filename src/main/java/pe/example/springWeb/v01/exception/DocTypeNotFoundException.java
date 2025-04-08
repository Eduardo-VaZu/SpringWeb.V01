package pe.example.springWeb.v01.exception;

public class DocTypeNotFoundException extends GlobalException{

    public DocTypeNotFoundException(String message) {
        super(message);
    }

    public DocTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
