package exceptions;

public class UncheckedExceptionHW extends RuntimeException {

    private final int errorCode;

    public UncheckedExceptionHW(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public void printMessage(){
        System.out.println(this.getMessage() + "\nError code: " + errorCode);
    }
}
