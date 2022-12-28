package Task5;

public class CustomCheckedException extends Exception{
    int code;

    public CustomCheckedException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
