public class NoAvailableMovesException extends RuntimeException {

    public NoAvailableMovesException(String message) {
        super(message);
    }

    public NoAvailableMovesException(String message, Throwable cause) {
    super(message, cause);
    }
}
