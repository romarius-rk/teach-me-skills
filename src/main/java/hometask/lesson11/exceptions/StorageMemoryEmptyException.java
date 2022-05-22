package hometask.lesson11.exceptions;

import java.util.List;

public class StorageMemoryEmptyException extends RuntimeException {

    private final List<String> list;

    public StorageMemoryEmptyException(List<String> list) {
        super();
        this.list = list;
    }

    @Override
    public String getMessage() {
        return "Storage memory is empty.";
    }
}

