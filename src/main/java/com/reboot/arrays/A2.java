package com.reboot.arrays;

import java.util.Arrays;

// MULTI-DIMENSIONAL ARRAY
public class A2 {
    public static void main(String[] args) {
        // Declaration
        int[][] arr = new int[2][2];

        // Entering values
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = i + 1;
            }
        }

        // Retrieving values
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
