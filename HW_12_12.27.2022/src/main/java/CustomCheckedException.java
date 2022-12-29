import java.io.FileNotFoundException;

public class CustomCheckedException extends Exception {

    //2. Custom Checked Exception yaratmaq. 2 field olsun - message, ve code
    private int code;

    public CustomCheckedException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
