package Task2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckedException extends IOException {
    public CheckedException (String msg){
        super(msg);
    }
}
