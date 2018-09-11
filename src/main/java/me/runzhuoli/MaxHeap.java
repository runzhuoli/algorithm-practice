package me.runzhuoli;

import java.util.Arrays;

public class MaxHeap {

    public static void main(String[] args) {
        Integer[] input = {0, 12, 213, 250, 290, 10};
        buildMaxHeap(input);
        System.out.println(Arrays.toString(input));
    }

    public static <T extends Comparable> void heapify(T[] array, int i) {
        int l = i * 2;
        int r = l + 1;
        int largest = i;
        if (l <= array.length - 1 && array[l].compareTo(array[i]) > 0)
            largest = l;
        if (r <= array.length - 1 && array[r].compareTo(array[largest]) > 0)
            largest = r;
        if (largest != i) {
            T temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, largest);
        }
    }

    public static <T extends Comparable> void buildMaxHeap(T[] array) {
        int n = array.length;
        for (int i = n / 2; i > 0; i--) {
            heapify(array, i);
        }
    }
}

