package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {2, 45, 5, 8, 10 , 324, 11};
        MergeSort.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void merge(int[] data, int indexLeft, int indexMiddle, int indexRight) {
        int[] tempArray = new int[indexRight - indexLeft + 1];
        int count = 0;
        int middle = indexMiddle;
        int start = indexLeft;
        while (true) {
            if(data[indexLeft] > data[indexMiddle + 1]){
                tempArray[count++] = data[indexMiddle + 1];
                indexMiddle++;

                if(indexMiddle >= indexRight) {
                    tempArray[count] = data[indexLeft];
                    break;
                }
            }
            else {
                tempArray[count++] = data[indexLeft];
                indexLeft++;

                if(indexLeft > middle) {
                    tempArray[count] = data[indexRight];
                    break;
                }
            }
        }
        for (int j : tempArray) {
            data[start++] = j;
        }
    }

    private static void split(int[] a, int l, int r) {
        if (l < r) { // still have a data
            int mid = (l + r) / 2;
            split(a, l, mid);
            split(a, mid + 1, r);
            merge(a, l, mid, r);
        }
    }

    public static void mergeSort(int[] a) {
        split(a, 0, a.length - 1);
    }
}
