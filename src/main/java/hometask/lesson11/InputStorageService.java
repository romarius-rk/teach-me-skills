package hometask.lesson11;

import hometask.lesson11.exceptions.StorageMemoryEmptyException;
import hometask.lesson11.exceptions.StringStorageFullException;

import java.util.ArrayList;
import java.util.List;

public class InputStorageService {

    private final List<String> stringsStorage = new ArrayList<>();

    public String serviceCore(String str) {
        switch (str) {
            case "exit":
                return "program closed";
            case "get":
                checkingStorageFill(stringsStorage);
                return getElementFromList(stringsStorage);
            default:
                addingRowToStorage(str);
                return "String add to storage";
        }
    }

    private String getElementFromList(List<String> stringList) {
        String firstElement = stringList.get(0);
        stringList.remove(0);
        return firstElement;
    }

    private void addingRowToStorage(String anyWord) {
        checkingStorageSize(stringsStorage);
        stringsStorage.add(anyWord);
    }

    private void checkingStorageSize(List<String> stringsStorage) {
        if (stringsStorage.size() >= 5) {
            throw new StringStorageFullException(stringsStorage);
        }
    }

    private void checkingStorageFill(List<String> stringsStorage) {
        if (stringsStorage.size() == 0){
            throw new StorageMemoryEmptyException(stringsStorage);
        }
    }
}
