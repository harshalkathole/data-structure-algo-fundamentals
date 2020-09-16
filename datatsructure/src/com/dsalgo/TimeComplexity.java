package com.dsalgo;

import java.util.logging.Logger;

public class TimeComplexity {
    private static Logger logger = Logger.getLogger(TimeComplexity.class.getName());

    private static void isPrime(int number) {
        // o(n2)
        for (int num = 0; num <= number; num++) {
            int i;
            for (i = 2; i < num; i++) {
                if (num % i == 0) {
                    break;
                }
            }
            if (i == num) {
                System.out.println(num);
            }
        }
    }

    private static void convertToBinary(int value) {
        // o(log n)
        String binaryValue = "";
        while (value > 0) {
            binaryValue = String.valueOf(binaryValue) + String.valueOf(value % 2);
            value = value / 2;
        }
        System.out.println(new StringBuilder(binaryValue).reverse().toString());
    }

    private static void printTable(int number) {
        // o(1)
        for (int i = 1; i <= 10; i++) {
            System.out.println(number * i);
        }
    }


    public static void main(String[] args) {
        //isPrime(100);
        convertToBinary(9);
        //printTable(10);
    }
}
