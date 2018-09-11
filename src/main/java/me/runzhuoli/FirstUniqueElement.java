package me.runzhuoli;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueElement {

    public static int findFirstUniqueElement(int[] array) {

        if (array == null || array.length == 0) {
            return -1;
        }

        if (array.length == 1) {
            return array[0];
        }

        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            map.computeIfPresent(array[i], (k, v) -> (new int[]{v[0], ++v[1]}));
            map.putIfAbsent(array[i], new int[]{i, 1});
        }
        int firstUniqueIndex = Integer.MAX_VALUE;

        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            if (entry.getValue()[1] == 1 && entry.getValue()[0] < firstUniqueIndex) {
                firstUniqueIndex = entry.getValue()[0];
            }
        }

        if (firstUniqueIndex < array.length) {
            return array[firstUniqueIndex];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 5, 2, 1, 7};
        System.out.println(findFirstUniqueElement(array));
    }
}
