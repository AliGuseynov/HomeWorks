public class CustomRuntimeException extends RuntimeException {

    //    1. Custom Runtime Exception yaratmaq. 2 field olsun - message, ve code
    private int code;

    public CustomRuntimeException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
