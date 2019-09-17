package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Scanner;

import org.junit.Test;

public class BiggerIsGreater {

    @Test
    public void biggerIsGreater() {
        assertThat(biggerIsGreater("ab"), is("ba"));
        assertThat(biggerIsGreater("bb"), is("no answer"));
        assertThat(biggerIsGreater("hefg"), is("hegf"));
        assertThat(biggerIsGreater("dhck"), is("dhkc"));
        assertThat(biggerIsGreater("dkhc"), is("hcdk"));
    }
    
    static String biggerIsGreater(String s) {
        char[] array = s.toCharArray();
        if (!nextPermutation(array))
            return "no answer";
        return new String(array);
    }
    
    static boolean nextPermutation(char[] array) {
        int right = array.length - 1;
        
        while (right > 0 && array[right - 1] >= array[right])
            right--;
        
        if (right <= 0)
            return false;
        
        int left = array.length - 1;
        while (array[left] <= array[right - 1])
            left--;
        
        char temp = array[right - 1];
        array[right - 1] = array[left];
        array[left] = temp;
        
        left = array.length - 1;
        while (right < left) {
            temp = array[right];
            array[right] = array[left];
            array[left] = temp;
            right++;
            left--;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)){
            int n = in.nextInt();
            for (int i = 0; i < n; i++)
                System.out.println(biggerIsGreater(in.next()));
        }
    }

}
