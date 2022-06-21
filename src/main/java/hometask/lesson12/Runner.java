package hometask.lesson12;

/*
1) Создать класс User с информацией об имени, возрасте, поле.
Сохранить при помощи сериализации объект этого класса в файл.
Создать логику по преобразованию сохраненного файла обратно в объект.
На дессериллизуемым объекте вызвать метод toString и распечатать данные об юзере в 	консоль
2) Есть файл с диалогом между двумя участниками спектакля вида
Имя1: 	текст, текст
	текст, текст
Имя2: 	текст, текст
	текст, текст
Имя1:	текст, текст и т.д.
Прочитать данный файл и вместо одного создать два, разделив данный по ролям
(в первом - только текст первого участника, во втором - второго)
 */

import common.ReadersFromCMD;

import java.io.*;
import java.util.*;

public class Runner {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ReadersFromCMD readers = new ReadersFromCMD();
        Scanner scanner = new Scanner(System.in);
//        User user1 = new User(readers.readStr("Enter your name:"),
//                readers.readStr("Enter your sex:"),
//                readers.readInt("Enter your age:"));
//        User user2 = new User(readers.readStr("Enter your name:"),
//                readers.readStr("Enter your sex:"),
//                readers.readInt("Enter your age:"));

        User user1 = new User("Лис", "1", 1);
        User user2 = new User("Маленький принц", "1", 1);

        List<User> actorsList = new ArrayList<>();
        actorsList.add(user1);
        actorsList.add(user2);

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Serialised\\save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(user1);
        objectOutputStream.writeObject(user2);

        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("D:\\Serialised\\save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        User user3 = (User) objectInputStream.readObject();
        User user4 = (User) objectInputStream.readObject();

        System.out.println(user3);
        System.out.println(user4);

        objectInputStream.close();

        File dialog = new File("D:\\teach-me-skills\\src\\main\\java\\hometask\\lesson12\\texts\\Dialog.txt");
        FileInputStream fileInput = new FileInputStream(dialog);

        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInput));

        ReadService service = new ReadService();
        File actorOneReplicas = new File("D:\\teach-me-skills\\src\\main\\java\\hometask\\lesson12\\texts\\Лис.txt");
        File actorTwoReplicas = new File("D:\\teach-me-skills\\src\\main\\java\\hometask\\lesson12\\texts\\Маленький принц.txt");
        actorOneReplicas.createNewFile();
        actorTwoReplicas.createNewFile();

        ReplicasSeparator separ = new ReplicasSeparator();
        separ.separator(service.readReplicas(reader, actorsList),user1,actorOneReplicas);
        separ.separator(service.readReplicas(reader, actorsList),user2,actorTwoReplicas);

    }
}
