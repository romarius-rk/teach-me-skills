package hometask.lesson13;

/*
1) Создать класс User с полями: имя, пол, возраст
2) Для данного класса переопределить методы hashCode и equals.
3) Указать что класс User имплементирует интерфейс Comparable.
Сравнение пользователей должно учитывать возраст и имя (при одинаковом возрасте - сравнивать первые буквы имени)
4) Создать несколько объектов типа User и поместить их в каждую коллекцию (list и set)
5) Cоздать сервис, который:
осуществляем поиск пользователя по имени (учитывает дубликаты)
возвращает коллекцию пользователей на основе пола.
возвращает отсортированную коллекцию по возрасту пользователей.
6) Заменить одну реализацию списка на другую. Убедиться, что сервис работает корректно.
Задан массив из целых чисел, в котором присутствуют повторения. В данном массиве найти число, которое встречается
максимальное число раз. Решение реализовать на основе Map
*/

import java.util.*;
import java.util.logging.Logger;

public class Runner {
    public static void main(String[] args) {

        String[] nameList = {"Lordy", "Ivan", "Ilya", "Helga"};
        String[] lastNameList = {"Babahov", "Pyshnoi", "Golubev"};
        String[] sexType = {"male", "female", "other"};
        List<User> userList = new ArrayList<>();
        Set<User> userSet = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            int rand1 = (int) (Math.random() * nameList.length);
            int rand2 = (int) (Math.random() * lastNameList.length);
            int rand3 = (int) (Math.random() * sexType.length);
            int rand4 = (int) (Math.random() * 100);
            userList.add(new User(nameList[rand1], lastNameList[rand2], sexType[rand3], rand4));
            userSet.add(new User(nameList[rand1], lastNameList[rand2], sexType[rand3], rand4));
        }

        UserService service = new UserService(userList);
        UserService userService = new UserService(userSet);

        System.out.println(userList);
        System.out.printf("findAllByName: %s\n", service.findAllByName("Lordy").toString());
        System.out.printf("findAllBySex: %s\n", service.findAllBySex("other").toString());
        System.out.printf("findAllSortByAge: %s\n", service.findAllSortByAge().toString());

        System.out.println(userSet);
        System.out.printf("findAllByName: %s\n", userService.findAllByName("Lordy").toString());
        System.out.printf("findAllBySex: %s\n", userService.findAllBySex("other").toString());
        System.out.printf("findAllSortByAge: %s\n", userService.findAllSortByAge().toString());

    }
}
