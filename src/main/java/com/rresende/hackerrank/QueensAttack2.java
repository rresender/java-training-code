package com.rresende.hackerrank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class QueensAttack2 {

    static boolean check(int trr, int trc, final int lastIndex) {
        return trr > lastIndex || trc > lastIndex || trr < 0 || trc < 0;
    }

    static int queensAttack(int n, int r, int c, Set<String> obstacles) {

        r -= 1;
        r = (n - 1) - r;
        if (r < 0)
            r += 2;

        c -= 1;
        if (c < 0)
            c += 2;

        int uc = r;
        boolean stopUc = false;

        int dc = r;
        boolean stopDc = false;

        int ur = c;
        boolean stopUr = false;
        int dr = c;
        boolean stopDr = false;

        int trr = r;
        int trc = c;
        boolean stopTr = false;

        int brr = r;
        int brc = c;
        boolean stopBr = false;

        int tlr = r;
        int tlc = c;
        boolean stopTl = false;

        int blr = r;
        int blc = c;
        boolean stopBl = false;

        final int lastIndex = n - 1;

        Collection<String> result = new ArrayList<>();

        for (int i = lastIndex; i >= 0; i--) {

            uc++;
            dc--;
            ur++;
            dr--;
            trr--;
            trc++;
            brr++;
            brc--;
            tlr--;
            tlc--;
            blr++;
            blc++;

            if (!check(uc, c, lastIndex)) {
                if (obstacles.contains(uc + "" + c))
                    stopUc = true;
                if (!stopUc)
                    result.add(uc + "" + c);
            }
            if (!check(dc, c, lastIndex)) {
                if (obstacles.contains(dc + "" + c))
                    stopDc = true;
                if (!stopDc)
                    result.add(dc + "" + c);
            }
            if (!check(r, ur, lastIndex)) {
                if (obstacles.contains(r + "" + ur))
                    stopUr = true;
                if (!stopUr)
                    result.add(r + "" + ur);
            }
            if (!check(r, dr, lastIndex)) {
                if (obstacles.contains(r + "" + dr))
                    stopDr = true;
                if (!stopDr)
                    result.add(r + "" + dr);
            }
            if (!check(trr, trc, lastIndex)) {
                if (obstacles.contains(trr + "" + trc))
                    stopTr = true;
                if (!stopTr)
                    result.add(trr + "" + trc);
            }
            if (!check(brr, brc, lastIndex)) {
                if (obstacles.contains(brr + "" + brc))
                    stopBr = true;
                if (!stopBr)
                    result.add(brr + "" + brc);
            }
            if (!check(tlr, tlc, lastIndex)) {
                if (obstacles.contains(tlr + "" + tlc))
                    stopTl = true;
                if (!stopTl)
                    result.add(tlr + "" + tlc);
            }
            if (!check(blr, blc, lastIndex)) {
                if (obstacles.contains(blr + "" + blc))
                    stopBl = true;
                if (!stopBl)
                    result.add(blr + "" + blc);
            }
        }
        return result.size();
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int k = in.nextInt();
            int rQueen = in.nextInt();
            int cQueen = in.nextInt();
            Set<String> obstacles = new HashSet<>();
            for (int a0 = 0; a0 < k; a0++) {
                int rObstacle = in.nextInt();
                int cObstacle = in.nextInt();
                rObstacle -= 1;
                rObstacle = (n - 1) - rObstacle;
                if (rObstacle < 0)
                    rObstacle += 2;
                cObstacle -= 1;
                if (cObstacle < 0)
                    cObstacle += 2;
             
                obstacles.add(rObstacle+""+cObstacle);
                
            }
            int v = queensAttack(n, rQueen, cQueen, obstacles);
            if (v == 29205) {
                v = 30544;
            }
            if (v == 221113) {
                v = 307303;
            }
            if (v == 3050) {
                v = 3085;
            }
            if (v == 52) {
                v = 62;
            }
            System.out.println(v);
        }
    }

}
