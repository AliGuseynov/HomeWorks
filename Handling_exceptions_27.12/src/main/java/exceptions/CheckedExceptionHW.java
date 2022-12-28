package exceptions;

public class CheckedExceptionHW extends Exception{

    private final int errorCode = 2;


    public CheckedExceptionHW() {
        super("One or both arguments are uncountable!");
    }

    public void printMessage(){
        System.out.println("Checked error: " + this.getMessage() + "\nError code: " + errorCode);
    }
}
