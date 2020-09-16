package com.dsalgo.sortingalgorithms;

import java.util.Arrays;

public class SelectionSort {
    // As it is going to be an arithmatic progression, time complexity is o(n^2)
    private static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new int[]{22, 78, 11, 45, 35})));
    }
}
