package org.example.exceptions;

public class ColumnNotFoundException extends Exception{

    public ColumnNotFoundException() {
        super("Necessary column in CSV file not found!");
    }
}
