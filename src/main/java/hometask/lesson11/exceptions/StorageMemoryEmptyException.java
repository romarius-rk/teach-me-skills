package hometask.lesson11.exceptions;

import java.util.List;

public class StorageMemoryEmptyException extends RuntimeException {

    public StorageMemoryEmptyException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Storage memory is empty.";
    }
}

