package pe.example.springWeb.v01.exception;

public abstract class GlobalException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }
}