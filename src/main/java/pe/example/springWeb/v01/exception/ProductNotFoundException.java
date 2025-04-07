package pe.example.springWeb.v01.exception;

public class ProductNotFoundException extends ProductException {
    
    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(String mensaje) {
        super(mensaje);
    }

    public ProductNotFoundException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}