package com.dsalgo.searchingalgorithms;

public class BinarySearch {
    //Time complexity will be o(log n)
    private static int binarySearch(int[] arr, int numberToSearch) {
        int left = 0;
        int right = arr.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (numberToSearch == arr[middle]) {
                return middle;
            }
            if (numberToSearch < arr[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    private static int binarySearchForString(String[] strArr, String stringToSearch) {
        int left = 0;
        int right = strArr.length-1;
        int middle;
        while (right <= left) {
            middle = (left+right)/2;
            if (stringToSearch.equals(strArr[middle])) {
                return middle;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        if (binarySearch(new int[]{11, 22, 33, 44, 55, 66, 77, 88}, 88) != -1) {
            System.out.println("Element found");
        } else {
            System.out.println("Element not found");
        }
    }
}
