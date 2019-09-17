package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HalloweenSale {
    
    @Test
    public void howManyGames() {
        assertThat(howManyGames(20, 3, 6, 80), is(6));
        assertThat(howManyGames(20, 3, 6, 85), is(7));
    }

    static int howManyGames(int p, int d, int m, int s) {
        int sum = p;
        int c = 0;
        while (sum <= s) {
            p-=d;
            if(p < m)
                p=m;
            sum+=p;
            c++;
        }
        return c;
    }

}
