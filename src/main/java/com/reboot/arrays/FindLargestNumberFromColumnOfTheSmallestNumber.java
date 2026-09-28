package com.reboot.arrays;

//TODO Fix if there's 2 smallest number

public class FindLargestNumberFromColumnOfTheSmallestNumber {
    public static void main(String[] args) {

        // Declaration
        int[][] arr = {
                {2, 4, 5, 7, 2},
                {3, 4, 7, 0, 7},
                {1, 2, 9, 5, 1}
        };

        int smallest = arr[0][0];

        int columnValue = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                int ithValue = arr[i][j];

                if (ithValue < smallest) {
                    smallest = ithValue;
                    columnValue = j;
                }
            }
        }

        int largest = arr[0][columnValue];
        for (int[] row : arr) {
            if(row[columnValue] > largest){
                largest = row[columnValue];
            }
        }

//        for (int i = 0; i < arr[0].length; i++) {
//            if (arr[i][columnValue] > largest) {
//                largest = arr[i][columnValue];
//            }
//        }

        System.out.println("Smallest value is: " + smallest);
        System.out.println("Largest value in that column is: " + largest);
    }
}
