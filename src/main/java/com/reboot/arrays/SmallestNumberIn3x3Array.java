package com.reboot.arrays;

//TODO Fix if there's 2 smallest number

public class SmallestNumberIn3x3Array {
    public static void main(String[] args) {
        // Declaration
        int[][] arr = {{2, 4, 5}, {3, 4, 7}, {1, 2, 9}};

        // Assuming smallest
        int smallest = arr[0][0];

        // Checking for smallest
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int ithValue = arr[i][j];
                if (ithValue < smallest) {
                    smallest = ithValue;
                }
            }
        }

        System.out.println("Smallest: " + smallest);
    }
}
