package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class CatsAndMouse {

    @Test
    public void moneySpent() {
        assertThat(catchTheMouse(1, 2, 3), is("Cat B"));
        assertThat(catchTheMouse(1, 3, 2), is("Mouse C"));
        assertThat(catchTheMouse(2, 3, 1), is("Cat A"));
    }

    private String catchTheMouse(int catA, int catB, int mouse) {
        int absCatA = Math.abs(mouse-catA);
        int absCatB = Math.abs(mouse-catB);
        if (absCatA == absCatB)
            return "Mouse C";
        if (absCatB < absCatA)
            return "Cat B";
        return "Cat A";
    }


}
