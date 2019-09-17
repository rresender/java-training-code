package com.rresende.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

public class IceCreamParlor {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Test
    public void iceCreamParlor() {
//        assertThat(solve(new int[] { 1, 4, 5, 3, 2 }, 4), is("1 4"));
//        assertThat(icecreamParlor(new int[] { 2, 2, 4, 3 }, 4), is("1 2"));
    }
    
    static int[] icecreamParlor(int m, int[] arr) {
        final List<Integer> result = new ArrayList<>();
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            int complement = m - arr[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                result.add(i+1);
                result.add(map.get(complement)+1);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
     }

    private static String solve(int[] arr, int money) {
        String r = "";
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            int x = money-v;
            m.put(i, x);
        }
        System.out.println(r);
        return r;
    }

    public static void main(String[] args) {
        int t = SCANNER.nextInt();
        SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = SCANNER.nextInt();
            SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = SCANNER.nextInt();
            SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = SCANNER.nextLine().split(" ");
            SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            solve(arr, money);
        }

        SCANNER.close();
    }
}
