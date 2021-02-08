package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Scanner;

import org.junit.Test;

public class SherlockSquares {

    @Test
    public void sherlockSquares() {
        assertThat(sherlockSquare(3, 9), is(2));
        assertThat(sherlockSquare(17, 24), is(0));
        assertThat(sherlockSquare(1, 16), is(4));
    }
    
    static int sherlockSquare(int a, int b) {
        return (int)Math.floor(Math.sqrt(b)) - (int)Math.floor(Math.sqrt(a-1));
    }
    
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(sherlockSquare(a, b));
        }
        in.close();
    }

}
