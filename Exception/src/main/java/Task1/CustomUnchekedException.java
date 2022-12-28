package Task1;

public class CustomUnchekedException extends RuntimeException{

    int code;
    public CustomUnchekedException(String message,int code) {
        super(message);
        this.code=code;
    }
}
