package Task2;

public class CustomCheckedException extends Exception{
    int code;

    public CustomCheckedException(String message, int code) {
        super(message);
        this.code = code;
    }
}
