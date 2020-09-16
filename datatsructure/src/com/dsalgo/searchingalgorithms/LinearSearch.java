package com.dsalgo.searchingalgorithms;

public class LinearSearch {
    // Time complexity for linear search in o(n)
    private static int performLinearSearch(int[] arr, int numberToSearch) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (numberToSearch == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        if (performLinearSearch(new int[]{101, 232, 7654, 243, 23456, 976}, 7654) != -1) {
            System.out.println("Element found");
        } else {
            System.out.println("Element not found");
        }
    }
}
