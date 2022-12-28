package exceptions;

public class GenericCheckedException extends Exception{
    private final int errorCode = 3;

    public GenericCheckedException(String exp) {
        super(exp);
    }

    public void printMessage(){
        System.out.println("Checked error: " + this.getMessage() + "\nError code: " + errorCode);
    }
}
