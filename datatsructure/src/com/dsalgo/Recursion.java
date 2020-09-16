package com.dsalgo;

import java.io.IOException;

public class Recursion {
    private static int factorial(int n) {
        if (n >= 1)
            return n * factorial(n - 1);
        else
            return 1;
    }

    public static void main(String[] args) throws IOException {
        int result = factorial(3);
        System.out.println(result);
    }
}
