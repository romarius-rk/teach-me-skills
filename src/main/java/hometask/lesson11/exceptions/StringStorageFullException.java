package hometask.lesson11.exceptions;

import java.util.List;

public class StringStorageFullException extends RuntimeException {

    public StringStorageFullException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Sting storage is full.";
    }
}
