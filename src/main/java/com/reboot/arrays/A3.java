package com.reboot.arrays;

public class A3 {
    public static void main(String[] args) {
//        int[][] arr = {
//                {2, 4, 5, 7, 2},
//                {3, 4, 7, 0, 7},
//                {1, 2, 9, 5, 1}
//        };
//
//        System.out.println(arr[0].length);
        {


            int[][] abc = { {10, 3, 5},{2, 4, 3}, {8, 6, 3}};

            int max = abc[0][0];


            for (int i = 0; i < 3; i++) {

                for (int j = 0; j < 3; j++) {

                    if (abc[i][j] > max) {

                        max = abc[i][j];

                    }

                }

            }

            System.out.println(max);


        }
    }
}
