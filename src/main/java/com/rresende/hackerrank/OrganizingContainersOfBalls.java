package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class OrganizingContainersOfBalls {

    @Test
    public void organizingContainersOfBalls() {
        assertThat(organizingContainersOfBalls(new int[][] {{1,1}, {1,1}}), is("Possible"));
        assertThat(organizingContainersOfBalls(new int[][] {{0,2}, {1,1}}), is("Impossible"));
    }
    
    static String organizingContainersOfBalls(int[][] m) {
        
        int[] row = new int[m.length];
        int[] column = new int[m.length];
        
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                row[i]+=m[i][j];
                column[j]+=m[i][j];
            }
        }
        
        Arrays.sort(row);
        Arrays.sort(column);
        
        if (Arrays.equals(row, column))
            return "Possible";
        
        return "Impossible"; 
    }
    
    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)){
            
        }
    }

}
