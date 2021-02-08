package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import org.junit.Test;

public class JesseAndCookies {

    @Test
    public void bookPages() {
        assertThat(
                cookies(2280, new int[] { 9660, 9902, 5775, 2183, 3974, 7742, 576, 8786, 7615, 5575, 6287, 5495, 161,
                        3520, 344, 805, 786, 3802, 4843, 7424, 634, 7916, 6989, 3499, 1216, 1293, 9965, 6299, 7899,
                        4763, 7272, 9785, 8469, 395, 1034, 8763, 8003, 9464, 5081, 2064, 4401, 6850, 8792, 1603, 7547,
                        3354, 8827, 887, 8151, 2470, 9995, 7228, 8198, 5600, 1829, 8814, 5282, 3930, 2481, 6873, 9165,
                        497, 2158, 1752, 878, 8448, 7862, 7685, 7988, 3536, 8227, 8863, 8663, 1823, 8510, 7065, 6927,
                        610, 4220, 7096, 7685, 6992, 976, 5081, 2389, 1844, 9843, 8741, 9582, 3479, 420, 4136 }),
                is(14));
        assertThat(cookies(6, new int[] { 1, 2, 3, 9, 10, 12 }), is(2));
        assertThat(cookies(10, new int[] { 1, 1, 1 }), is(-1));
    }

    static int cookies(final int k, final int[] A) {
        final PriorityQueue<Integer> q = new PriorityQueue<Integer>(Arrays.stream(A).boxed().collect(Collectors.toList()));
        int op = 0;
        while (q.size() > 1 && q.peek() < k) {
            q.add(q.poll() + 2*q.poll());
            op++;
        }
        if (q.peek() < k) {
            return -1;
        }
        return op;
    }
}
