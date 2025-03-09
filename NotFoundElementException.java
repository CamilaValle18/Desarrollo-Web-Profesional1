package edu.utvt.springdata.common;

public class NotFoundElementException extends RuntimeException {

    public NotFoundElementException() {
        super();
    }

    public NotFoundElementException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {

        String message = "Non element found";
        return super.getMessage() != null ? super.getMessage() : message;
    }
}
