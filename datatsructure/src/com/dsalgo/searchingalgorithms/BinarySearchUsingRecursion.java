package com.dsalgo.searchingalgorithms;

public class BinarySearchUsingRecursion {
    private static int recursiveBinarySearch(int[] arr, int left, int right, int numberToSearch) {
        if (right < left)
            return -1;
        int mid = (left + right) / 2;
        if (numberToSearch == arr[mid])
            return mid;
        int index;
        if (numberToSearch < arr[mid])
            index = recursiveBinarySearch(arr, left, mid - 1, numberToSearch);
        else
            index = recursiveBinarySearch(arr, mid + 1, right, numberToSearch);
        return index;

    }

    public static void main(String[] args) {
        if (recursiveBinarySearch(new int[]{11, 22, 33, 44, 55}, 0, 4, 7845) != -1) {
            System.out.println("Element found");
        } else {
            System.out.println("Element not found");
        }
    }
}
