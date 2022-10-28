package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {2, 3, 3, 2, 3, 1 ,2 };
        MergeSort.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void merge(int[] data, int indexLeft, int indexMiddle, int indexRight) {
        int size = indexRight - indexLeft + 1;
        int[] tempArray = new int[size];
        int count = 0;
        int middle = indexMiddle;
        int start = indexLeft;
        for(int i = 0; i <= size; i++) {
            if(data[indexLeft] > data[indexMiddle + 1]){
                tempArray[count++] = data[indexMiddle + 1];
                indexMiddle++;
            }
            else if(data[indexLeft] == data[indexMiddle + 1]){
                tempArray[count++] = data[indexMiddle + 1];
                tempArray[count++] = data[indexLeft];
                indexMiddle++;
                indexLeft++;
                i++;
                if(count == size) break;
            }
            else {
                tempArray[count++] = data[indexLeft];
                indexLeft++;
            }

            if(indexLeft > middle) {
                tempArray[count] = data[indexRight];
                break;
            }

            if(indexMiddle >= indexRight) {
                tempArray[count] = data[indexLeft];
                break;
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
