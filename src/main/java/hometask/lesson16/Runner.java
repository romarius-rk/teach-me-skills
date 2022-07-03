package hometask.lesson16;

/*
1) Создать коллекцию класса ArrayList наполнить ее
элементами рандомными элементами типа Integer.
С помощью Stream'ов:
- Удалить дубликаты
- Вывести все четные элементы в диапазоне от 7 до 17 (включительно) // filter
- Каждый элемент умножить на 2 // reduce
- Отсортировать и вывести на экран первых 4 элемента // limit
- Вывести количество элементов в стриме // count
- Вывести среднее арифметическое всех чисел в стриме // average
2) Создать класс Family со следующими полями
фамилия (уникально в рамках задания)
адресс
средняя зарплата на члена семьи
список детей (ребёнок имеет имя, возраст, пол)
С помощью Stream'ов:
- Сгенерировать map где ключ - фамилия семьи, а значение - размер зп
- Вывести количество мальчиков (в разрезе всех семей)
- Вывести всех девочек
- Вывести информацию сколько у какой семью детей
- вывести есть ли хоть одна семья у которой есть ребенок с именем ...
*/

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
        List<Integer> justList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            justList.add((int) (Math.random() * 15));
        }
//        System.out.println(justList);
//        System.out.println();
//        justList.stream().distinct().forEach(System.out::println);
//        justList.stream().filter(x -> x % 2 == 0 && x > 6 && x < 18).forEach(System.out::println);
//        justList.stream().map(x-> x*2).forEach(System.out::println);
//        System.out.println(justList.stream().count());
//        System.out.println(justList.stream().mapToDouble(x -> x).average().getAsDouble());

        Family family1 = new Family("Petrovi", "L'vov",
                List.of(new Parent("Ivan", "male", 16, 1000d),
                        new Parent("Mary", "female", 17, 1377d)),
                List.of(new Child("Garik", "female", 1)));

        Family family2 = new Family("Ivanovi", "Minsk",
                List.of(new Parent("Roman", "male", 20, 2388d),
                        new Parent("Olga", "female", 18, 1488d)),
                List.of(new Child("Harlamov", "male", 3),
                        new Child("Henry", "male", 2)));

        Map<String, Double> familyMap = Stream.of(family1, family2)
                .collect(Collectors.toMap(Family::getLastName, Family::getAverageSalary));

        System.out.println(Stream.of(family1, family2)
                .map(Family::getChildren)
                .flatMap(Collection::stream)
                .filter(child -> Objects.equals(child.sex, "male"))
                .count());

        Stream.of(family1, family2).map(Family::getChildren)
                .flatMap(Collection::stream)
                .filter(child -> Objects.equals(child.sex, "female"))
                .forEach(System.out::println);

        Stream.of(family1, family2)
                .collect(Collectors.toMap(Family::getLastName, family -> family.getChildren().size()))
                .entrySet().stream().forEach(System.out::println);

        boolean isJerryPresent = Stream.of(family1, family2)
                .map(Family::getChildren)
                .flatMap(Collection::stream)
                .anyMatch(child -> Objects.equals(child.name, "Henry"));
        System.out.println(isJerryPresent);
    }
}

