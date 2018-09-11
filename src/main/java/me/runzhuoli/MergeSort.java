package me.runzhuoli;

public class MergeSort {
    public static void mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(array, temp, leftStart, middle);
        mergeSort(array, temp, middle + 1, rightEnd);
        merge(array, temp, leftStart, rightEnd);
    }

    public static void merge(int array[], int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int lp = leftStart;
        int rp = leftEnd + 1;
        for (int i = 0; i <= rightEnd - leftStart; i++) {
            if (lp > leftEnd) {
                temp[leftStart + i] = array[rp++];
            } else if (rp > rightEnd) {
                temp[leftStart + i] = array[lp++];
            } else {
                temp[leftStart + i] = array[lp] < array[rp] ? array[lp++] : array[rp++];
            }
        }
        System.arraycopy(temp, leftStart, array, leftStart, rightEnd - leftStart + 1);
    }

    public static void main(String[] args) {
        int[] testArray = {6,5,4,3,2,1};
//        mergeSort(testArray);
//        System.out.println(Arrays.toString(testArray));
        System.out.println(countInversions(testArray));
    }

    public static int countInversions(int[] array) {
        return countInversions(array, new int[array.length], 0, array.length - 1);
    }

    private static int countInversions(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return 0;
        }
        int middle = (leftStart + rightEnd) / 2;
        int leftInversions = countInversions(array, temp, leftStart, middle);
        int rightInversions = countInversions(array, temp, middle + 1, rightEnd);
        int splitInversions = countSplitInversions(array, temp, leftStart, rightEnd);
        return leftInversions + rightInversions + splitInversions;
    }

    private static int countSplitInversions(int[] array, int[] temp, int leftStart, int rightEnd) {
        int inversions = 0;
        int leftEnd = (leftStart + rightEnd) / 2;
        int lp = leftStart;
        int rp, rightStart;
        rp = rightStart = leftEnd + 1;
        for (int i = 0; i <= rightEnd - leftStart; i++) {
            if (lp > leftEnd) {
                temp[leftStart + i] = array[rp++];
            } else if (rp > rightEnd) {
                temp[leftStart + i] = array[lp++];
            } else {
                if (array[lp] < array[rp]) {
                    temp[leftStart + i] = array[lp++];
                } else {
                    temp[leftStart + i] = array[rp++];
                    inversions += rightStart - lp;
                }
            }
        }
        System.arraycopy(temp, leftStart, array, leftStart, rightEnd - leftStart + 1);
        return inversions;
    }
}
