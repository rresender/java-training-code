package com.rresende.hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DynamicArray {

    static Integer lastAns = 0;

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int sqSize = in.nextInt();
            int qSize = in.nextInt();
            int[][] queries = new int[qSize][3];

            for (int i = 0; i < qSize; i++) {
                for (int j = 0; j < 3; j++) {
                    queries[i][j] = in.nextInt();
                }
            }

            // int sqSize = 2;
            // int qSize = 5;
            //
            // int[][] queries = new int[][]{{1,0,5},{1,1,7},{1,0,3 },{2,1,0},{2,1,1}};
            //
            // for (int i = 0; i < qSize; i++) {
            // for (int j = 0; j < 3; j++) {
            // System.out.print(queries[i][j]+" ");
            // }
            // System.out.println();
            // }
            List<LinkedList<Integer>> listSeq = new ArrayList<>(sqSize);
            for (int i = 0; i < sqSize; i++) {
                listSeq.add(new LinkedList<Integer>());
            }
            for (int i = 0; i < qSize; i++) {
                process(queries[i], listSeq, sqSize);
            }
        }
    }

    static void process(int[] query, List<LinkedList<Integer>> listSeq, int sqSize) {

        int type = query[0];
        int x = query[1];
        int y = query[2];

        if (type == 1) {
            int idx = ((x ^ lastAns) % sqSize);
            List<Integer> seq = listSeq.get(idx);
            seq.add(y);
        } else {
            int idx = ((x ^ lastAns) % sqSize);
            List<Integer> seq = listSeq.get(idx);
            lastAns = seq.get(y % seq.size());
            System.out.println(lastAns);
        }
    }

}
