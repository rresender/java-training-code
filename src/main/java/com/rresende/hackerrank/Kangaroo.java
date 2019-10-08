package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Scanner;

import org.junit.Test;

public class Kangaroo {

    @Test
    public void kangaroo() {
        assertThat(kangaroo(0, 3, 4, 2), is("YES"));
        assertThat(kangaroo(0, 2, 5, 3), is("NO"));
        assertThat(kangaroo(21, 6, 47, 3), is("NO"));
        assertThat(kangaroo(30, 20, 180, 15), is("YES"));
        assertThat(kangaroo(43, 5, 49, 3), is("YES"));
    }
    
    private String kangaroo(int x1, int v1, int x2, int v2) {
        int m = 10000;
        x1+=v1;
        x2+=v2;
        while (m >= 0) {
            if (x1 == x2)
                return "YES";
            m--;
            x1+=v1;
            x2+=v2;
        }
        return "NO";
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)){
            
        }
    }

}
