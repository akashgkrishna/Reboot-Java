package com.reboot.arrays;

import java.util.Arrays;

public class A1 {
    public static void main(String[] args) {
        // Array is container that stores multiple values of same datatypes
        int[] arr = new int[5]; // Declaration

        // Entering values to the array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        // Printing the values of the array
        System.out.println(Arrays.toString(arr));

        // Other way of declaring and entering values in the array
        int[] arr2 = {6, 7, 8, 9, 10};

        // Printing the values of the array
        System.out.println(Arrays.toString(arr));


    }
}


