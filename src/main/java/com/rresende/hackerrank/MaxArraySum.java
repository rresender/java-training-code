package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class MaxArraySum {

    @Test
    public void arraysLeftRotation() {
        assertThat(maxSubsetSum(new int[] { 3, 7, 4, 6, 5 }), is(13));
        assertThat(maxSubsetSum(new int[] { 2, 1, 5, 8, 4 }), is(11));
        assertThat(maxSubsetSum(new int[] { 3, 5, -7, 8, 10 }), is(15));

    }

    // static int maxSubsetSum(int[] arr) {
    // int[] result = new int[arr.length];
    //
    // IntStream.range(0, arr.length).forEach(i -> result[i] = (arr[i] * (i + 1) *
    // (arr.length - i)));
    //
    // return Arrays.stream(result).max().getAsInt();
    // }

    static int maxSubsetSum(int[] a) {
        int s0 = 0; // will hold the sum till i-2
        int s1 = 0;// will hold the sum till i-1
        for (int e : a) {
            int s = s0 + e;
            int x = Math.max(s, s1);// max(sum till (i-2)+a[i], sum till (i-1))
            s0 = s1;
            s1 = x;
        }
        return s1;
    }

    // static int maxSubsetSum(int[] arr) {
    // int newsum=arr[0];
    // int max=arr[0];
    // for(int i=1;i<arr.length;i++){
    // newsum=Math.max(newsum+arr[i],arr[i]);
    // max= Math.max(max, newsum);
    // }
    // return max;
    // }

}
