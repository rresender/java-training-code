package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class ChessboardGame {

    
    @Test
    public void biggerIsGreater() { 
        assertThat(chessboardGame(5, 2), is("Second"));
        assertThat(chessboardGame(5, 3), is("First"));
        assertThat(chessboardGame(8, 8), is("First"));
    }
    
    static String chessboardGame(final int x, final int y) {
        final int _x=x%4; 
        final int _y=y%4;
        if((_y==0)||(_y==3)||(_x==0)||(_x==3)) {
            return "First";
        }
        return "Second";
    }

}
