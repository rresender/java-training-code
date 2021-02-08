package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

public class ClimbingTheLeaderboard {

    @Test
    public void climbingTheLeaderboards() {
        assertThat(climbing(new int[] { 100, 100, 50, 40, 40, 20, 10 }, new int[] { 5, 25, 50, 120 }),
                is(new int[] { 6, 4, 2, 1 }));
    }

    private int[] climbing(int[] generalScores, int[] aliceScores) {
        int[] ranks = configRanks(generalScores);
        int[] aliceRank = new int[aliceScores.length];
        for (int j = 0; j < aliceScores.length; j++) {
            for (int i = generalScores.length - 1; i >= 0; i--) {
                if (aliceScores[j] > generalScores[i])
                    continue;
                if (aliceScores[j] == generalScores[i]) {
                    aliceRank[j] = ranks[i];
                    break;
                } else {
                    aliceRank[j] = ranks[i] + 1;
                    break;
                }
            }
            if (aliceRank[j] == 0) {
                aliceRank[j] = 1;
            }
        }

        return aliceRank;
    }

    private int[] configRanks(int[] scores) {
        final int[] ranks = new int[scores.length];
        int rank = 1;
        ranks[0] = rank;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i - 1] == scores[i]) {
                ranks[i] = ranks[i - 1];
            } else {
                ranks[i] = ++rank;
            }
        }
        return ranks;
    }

    public static void main(String[] args) throws Exception {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        new BufferedWriter(new OutputStreamWriter(System.out));

        final int n = Integer.parseInt(reader.readLine());
        final int[] scores = new int[n];
        final int[] ranks = new int[scores.length];

        int rank = 1;
        ranks[0] = rank;

        final String[] sScores = reader.readLine().split(" ");
        scores[0] = Integer.parseInt(sScores[0]);
        for (int scores_i = 1; scores_i < n; scores_i++) {
            scores[scores_i] = Integer.parseInt(sScores[scores_i]);
            if (scores[scores_i - 1] == scores[scores_i]) {
                ranks[scores_i] = ranks[scores_i - 1];
            } else {
                ranks[scores_i] = ++rank;
            }
        }

        final int m = Integer.parseInt(reader.readLine());
        final String[] sAlice = reader.readLine().split(" ");
        
        int i = scores.length - 1;
        for (int alice_i = 0; alice_i < m; alice_i++) {
            int alice = Integer.parseInt(sAlice[alice_i]);
            boolean first = true;
            for (; i >= 0; i--) {
                if (alice > scores[i])
                    continue;
                if (alice == scores[i]) {
                    System.out.println(ranks[i]);
                    first = false;
                    break;
                }
                System.out.println(ranks[i] + 1);
                first = false;
                break;
            }
            if (first) {
                System.out.println(1);
            }
        }
    }

}
