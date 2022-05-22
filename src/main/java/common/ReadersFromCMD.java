package common;

import java.util.Scanner;

public class ReadersFromCMD {

    private final Scanner scanner = new Scanner(System.in);

    public String readStr(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    public int readInt(String msg) {
        System.out.println(msg);
        return Integer.parseInt(scanner.nextLine());
    }

    public float readFlot(String msg) {
        System.out.println(msg);
        return Float.parseFloat(scanner.nextLine());
    }
}

