public class CustomCheckedException extends Exception{
    private final int code = 5;
    public CustomCheckedException(){
        super("Division to 0 exception");
    }
    public void printMessage(){
        System.out.println(this.getMessage() + "\nErrorCode: " + code);
    }
}
