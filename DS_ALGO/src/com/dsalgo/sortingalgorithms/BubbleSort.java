package com.dsalgo.sortingalgorithms;

import java.util.Arrays;

public class BubbleSort {
    private static int[] bubbleSort(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            count++;
            for (int j = 0; j < arr.length - 1; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Count: " + count);
        return arr;
    }

    // It improves time complexity as number of iterations in the inner loop has been reduced
    private static int[] optimisedBubbleSort(int[] arr) {
        int optimisedCount = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            optimisedCount++;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                optimisedCount++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Optimised count: " + optimisedCount);
        return arr;
    }

    // It improves time complexity as number of iterations in the inner loop has been reduced
    // o(n) : This is the best case time complexity for
    private static int[] optimisedSortedBubbleSort(int[] arr) {
        int optimisedCount = 0;
        boolean isSwapped = false;
        for (int i = 0; i < arr.length - 1; i++) {
            optimisedCount++;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                optimisedCount++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
        System.out.println("Optimised count for Sorted Array: " + optimisedCount);
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{99, 22, 77, 66, 33, 11})));
        System.out.println(Arrays.toString(optimisedBubbleSort(new int[]{99, 22, 77, 66, 33, 11})));
        System.out.println(Arrays.toString(optimisedSortedBubbleSort(new int[]{11, 22, 33, 44, 55, 66})));
    }
}
