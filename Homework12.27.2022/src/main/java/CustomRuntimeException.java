public class CustomRuntimeException extends Exception{
    private final int code;

    public CustomRuntimeException(String message, int code) {
        super(message);
        this.code = code;
    }


    public void printMessage(){
        System.out.println(this.getMessage() + "\nErrorCode: " + code);
    }
}
