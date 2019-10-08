package com.rresende.hackerrank;

import java.util.Scanner;

public class LeftRotation {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            int size = in.nextInt();
            int rotation = in.nextInt();

            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i + 1;
            }

            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            int count = 0;
            while (count++ < rotation) {
                int temp = arr[0];
                for (int i = 0; i < arr.length - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[arr.length - 1] = temp;
            }

            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

}
