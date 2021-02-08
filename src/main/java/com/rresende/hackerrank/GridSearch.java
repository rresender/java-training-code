package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class GridSearch {

    @Test
    public void gridSearch() {
        assertThat(gridSearch(
                new String[] { "7283455864", "6731158619", "8988242643", "3830589324", "2229505813", "5633845374",
                        "6473530293", "7053106601", "0834282956", "4607924137" },
                new String[] { "9505", "3845", "3530" }), is("YES"));
        assertThat(gridSearch(new String[] { "400453592126560", "114213133098692", "474386082879648", "522356951189169",
                "887109450487496", "252802633388782", "502771484966748", "075975207693780", "511799789562806",
                "404007454272504", "549043809916080", "962410809534811", "445893523733475", "768705303214174",
                "650629270887160" }, new String[] { "99", "99" }), is("NO"));
        assertThat(gridSearch(new String[] { "456712", "561245", "123667", "781288" }, new String[] { "45", "67" }),
                is("YES"));

        assertThat(gridSearch(new String[] { "123412", "561212", "123634", "781288"}, new String[] { "12", "34" }),
                is("YES"));

    }
    
    static String gridSearch(final String[] G, final String[] P) {
        final int n = G[0].length() - P[0].length() + 1;
        final String d = " ";
        final String p = String.format(".{%s}", n);
        final List<String> c = Collections.nCopies(n, d);
        final String j1 = String.join("", c);
        final String j2 = String.join(d, G);
        final String g = String.format("%s%s", j2, j1);
        final String j3 = String.join(p, P);
        final String r = String.format(".*%s%s.*", j3, p);
        return g.matches(r)? "YES" : "NO";
    }
    
//    static String gridSearch(final String[] G, final String[] P) {
//        final boolean[] v = new boolean[G.length];
//        int c = 0;
//        String init = "X";
//        Integer f = null;
//        for (final String p : P) {
//            for (int i = 0; i < G.length; i++) {
//                if (v[i])
//                    continue;
//                final String g = G[i];
//                final int idx = g.lastIndexOf(p);
//                if (idx != -1 && f == null && !v[i]) {
//                    f = idx;
//                    c++;
//                    v[i] = true;
//                    init = p;
//                    break;
//                }
//                if (f != null && f == idx) {
//                    v[i] = true;
//                    c++;
//                } 
//                else if (g.contains(init)) {
//                    f = idx;
//                    c = 1;
//                    v[i] = true;
//                }
//            }
//        }
//        return c >= P.length ? "YES" : "NO";
//    }

}
