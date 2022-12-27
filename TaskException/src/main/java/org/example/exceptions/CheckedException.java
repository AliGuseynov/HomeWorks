package org.example.exceptions;

import java.io.IOException;

public class CheckedException extends IOException {

    public CheckedException(String message){
        super(message);
    }
}
