package com.h2;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] numbers = {10, 8, 9, 7};
        int sum = add(numbers);
        System.out.println("sum = " + sum);
    }

    public static int doubleTheNumber(int number) {
        return number * 2;
    }

    private static int add(int[] numbers) {
        return Arrays.stream(numbers)
                     .reduce(0, Integer::sum);
    }
}
