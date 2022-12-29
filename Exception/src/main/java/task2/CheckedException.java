package task2;

import java.io.IOException;

public class CheckedException extends IOException {
    public CheckedException (String msg){
        super(msg);
    }
}
