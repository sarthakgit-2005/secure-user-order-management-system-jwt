package Programs.User_Order_Management.exception;

public class DuplicateResourceException extends RuntimeException {

    public DuplicateResourceException(String message) {
        super(message);
    }
}

//custom exception (DuplicateResourceException extends runtime exception so unchecked exception)