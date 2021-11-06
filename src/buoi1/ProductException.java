package buoi1;

public class ProductException extends RuntimeException {
    private String message;

    public ProductException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
