package hometask.lesson11.exceptions;

import java.util.List;

public class StringStorageFullException extends RuntimeException {

    private final List<String> list;

    public StringStorageFullException(List<String> list) {
        super();
        this.list = list;
    }

    @Override
    public String getMessage() {
        return "Sting storage is full.";
    }
}
