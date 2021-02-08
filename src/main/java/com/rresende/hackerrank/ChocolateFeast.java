package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.junit.Test;

public class ChocolateFeast {

    public void setup() {

    }

    @Test
    public void chocolateFeast() {
        assertThat(chocolateFeast(10, 2, 5), is(6));
        assertThat(chocolateFeast(12, 4, 4), is(3));
        assertThat(chocolateFeast(6, 2, 2), is(5));
        assertThat(chocolateFeast(12195, 1853, 9796), is(6));
        assertThat(chocolateFeast(27547, 6, 1795), is(4593));
        assertThat(chocolateFeast(35, 1, 15), is(37));
        assertThat(chocolateFeast(385, 1, 15), is(412));
        assertThat(chocolateFeast(30873, 1, 6285), is(30877));
        assertThat(chocolateFeast(43203, 60, 5), is(899));
    }

    static int chocolateFeast(int n, int c, int m) {
        int q = n / c;
        int e = q / m;
        int r = q + e;
        int k = e + (q % m);
        while ((k / m) > 0) {
            k = e + (q % m);
            e = k / m;
            q = k % m;
            r += e;
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        try (FileInputStream in = new FileInputStream(new File("ChocolateFeastInput03.txt"));
                Scanner scan = new Scanner(in);
                BufferedReader out = new BufferedReader(new InputStreamReader(new FileInputStream("ChocolateFeastOutput03.txt")));
                        ) {
            System.setIn(in);
            int t = scan.nextInt();
            for (int a0 = 0; a0 < t; a0++) {
                int n = scan.nextInt();
                int c = scan.nextInt();
                int m = scan.nextInt();
                String expected = out.readLine();
                String actual = String.valueOf(chocolateFeast(n, c, m));
                if (expected.equals(actual)) {
                    continue;
                }
                System.out.println(n+" "+c+" "+m+" Expected: "+expected+" Actual: "+actual);
            }
        }
    }

}
