package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {4, 7, 1, 12, 90, 7, 2, 55};
        MergeSort.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void merge(int[] data, int indexLeft, int indexMiddle, int indexRight) {
        int size = indexRight - indexLeft + 1;
        int[] tempArray = new int[size];
        int count = 0;
        int middle = indexMiddle;
        int start = indexLeft;
        while(true) {
            if(data[indexLeft] > data[indexMiddle + 1]){
                tempArray[count++] = data[indexMiddle + 1];
                indexMiddle++;
            }
            else if(data[indexLeft] < data[indexMiddle + 1]){
                tempArray[count++] = data[indexLeft];
                indexLeft++;
            }
            else{
                tempArray[count++] = data[indexMiddle + 1];
                tempArray[count++] = data[indexLeft];
                indexMiddle++;
                indexLeft++;
                if(count == size) break;
            }

            if(indexLeft > middle) {
                while(indexMiddle < indexRight) {
                    tempArray[count++] = data[indexMiddle + 1];
                    indexMiddle++;
                }
                break;
            }
            if(indexMiddle >= indexRight) {
                while(indexLeft <= middle) {
                    tempArray[count++] = data[indexLeft++];
                }
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
