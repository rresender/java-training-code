package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Scanner;

import org.junit.Test;

public class Encryption {

    @Test
    public void encryption() {
        assertThat(encrypt("haveaniceday"), is("hae and via ecy"));
        assertThat( encrypt("chillout"), is("clu hlt io"));
        assertThat(encrypt("feedthedog"), is("fto ehg ee dd"));
        assertThat(encrypt("ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots"), is("imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau"));
    }

    static String encrypt(String s) {
        double sqrt = Math.sqrt(s.length());
        
        int r = (int) Math.floor(sqrt);
        int c = (int) Math.ceil(sqrt);
        
        if (r * c < s.length())
            r++;
        
        char[][] grid = new char[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) 
            for (int j = 0; j < c; j++) 
                if (index < s.length())
                    grid[i][j] = s.charAt(index++);
        
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < c; i++) { 
            for (int j = 0; j < r; j++) {
                if (grid[j][i] == 0)
                    continue;
                builder.append(grid[j][i]);
            }
            builder.append(" ");
        }
        return new String(builder.toString().trim());
    }

    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)) {

        }
    }

}
