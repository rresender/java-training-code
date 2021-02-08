package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MigratoryBirds {

    @Test
    public void migratoriesBirds() {
        assertThat(migratoryBirds(1, 1), is(1));
        assertThat(migratoryBirds(2, 1, 2), is(1));
        assertThat(migratoryBirds(2, 1, 2, 2), is(2));
        assertThat(migratoryBirds(6, 1, 4, 4, 4, 5, 3), is(4));
    }
    
    private Integer migratoryBirds(int n, int...ar){
        
        if (ar.length == 1) {
            return ar.length;
        }
        
        final Map<Integer, Integer> counts = new HashMap<>();
        
        int max = 0;
        int lowest = Integer.MAX_VALUE;
        
        for (int e : ar) {
            
            Integer v = counts.get(e);
            
            if (v == null)
                v = 0;
            
            counts.put(e, ++v);
            
            if (v > max) {
                max = v;
                lowest = e;
            }
            else if (v == max)
                if (e < lowest)
                    lowest = e;
        }
        
        return lowest;
    }

}
