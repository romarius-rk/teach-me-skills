package hometask.lesson13;

import java.util.HashMap;
import java.util.Map;

public class ArrayMapper {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 5, 6, 4, 5, 4};
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : arr) {
            map.merge(i, 1, Integer::sum);
        }
        System.out.println(map.toString());
    }
}
