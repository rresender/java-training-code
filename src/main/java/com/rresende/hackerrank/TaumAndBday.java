package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class TaumAndBday {

    @Test
    public void aumAndBday() {
        assertThat(taumAndBday(10, 10, 1, 1, 1), is(20L));
        assertThat(taumAndBday(5, 9, 2, 3, 4),   is(37L));
        assertThat(taumAndBday(3, 6, 9, 1, 1),   is(12L));
        assertThat(taumAndBday(7, 7, 4, 2, 1),   is(35L));
        assertThat(taumAndBday(3, 3, 1, 9, 2),   is(12L));
    }
    
    static long taumAndBday(long qtyB, long qtyW, long priceB, long priceW, long costZ) {
        
        if (priceB > priceW) {
            if ((priceW + costZ) < priceB) {
                return ((priceW + costZ)*qtyB) + (priceW*qtyW);
            }
        } else {
            if ((priceB + costZ) < priceW) {
                return ((priceB + costZ)*qtyW) + (priceB*qtyB);
            }
        }
        return (priceB*qtyB) + (priceW*qtyW);
    }
    
    

}
