package zadanie02;

public class InvalidPeselException extends IllegalStateException {
    public InvalidPeselException(String message) {
        super(message);
    }
}
