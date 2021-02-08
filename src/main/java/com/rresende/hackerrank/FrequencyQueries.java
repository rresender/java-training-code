package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class FrequencyQueries {
    
    
    @Test
    public void freqQuery() { 
        assertThat(freqQuery(getList(new int[] {1, 5}, 
                                     new int[] {1, 6}, 
                                     new int[] {3, 2},
                                     new int[] {1, 10},
                                     new int[] {1, 10},
                                     new int[] {1, 6},
                                     new int[] {2, 5},
                                     new int[] {3, 2}
                                     
                )), is(Arrays.asList(new Integer[] {0, 1})));
    }
    
//    
//    freq = Counter()
//
//            cnt = Counter()
//
//            arr = []
//
//            for q in queries:
//                if q[0]==1:
//                    cnt[freq[q[1]]]-=1
//                    freq[q[1]]+=1
//                    cnt[freq[q[1]]]+=1
//
//                elif q[0]==2:
//                    if freq[q[1]]>0:
//                        cnt[freq[q[1]]]-=1
//                        freq[q[1]]-=1
//                        cnt[freq[q[1]]]+=1
//
//                else:
//                    if cnt[q[1]]>0:
//                        arr.append(1)
//                    else:
//                        arr.append(0)
    
    static List<Integer> freqQuery(final List<int[]> queries) {

        final Map<Integer, Integer> m = new HashMap<>();
        final Map<Integer, Integer> f = new HashMap<>();
        final List<Integer> r = new ArrayList<>();

        for (final int[] q : queries) {

            final int op = q[0];
            final int v = q[1];

            if (op == 3) {
                if (v == 0) {
                    r.add(1);
                }
                r.add(f.get(v) == null ? 0 : 1);
                continue;
            }

            final int oldF = m.getOrDefault(v, 0);
            final int oldO = f.getOrDefault(oldF, 0);

            int newF = oldF + 1;

            if (op == 2) {
                newF = oldF - 1;
            }

            final int newO = f.getOrDefault(newF, 0);

            if (newF < 1) {
                m.remove(v);
            } else {
                m.put(v, newF);
            }

            if ((oldO - 1) < 1) {
                f.remove(oldF);
            } else {
                f.put(oldF, oldO - 1);
            }

            f.put(newF, newO + 1);
        }
        return r;
    }
    
//    static List<Integer> freqQuery(List<int[]> queries) {
//        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
//        List<Integer> r = new ArrayList<>();
//        for (int[] q : queries) {
//            Integer o = q[0];
//            Integer v = q[1];
//            if (o == 1) {
//                Integer elem = m.getOrDefault(v, 0);
//                m.put(v, ++elem);
//                continue;
//            }
//            if (o == 2) {
//                Integer elem = m.getOrDefault(v, 1);
//                m.put(v, --elem);
//                continue;
//            }
//            if (o == 3) {
//                Integer e = m.values().stream().filter(x -> x == v)
//                .findAny()
//                .orElse(null);
//                r.add(e == null || e == 0 ? 0 : 1);
//            }
//        }
//        
//        return r;
//    }
    
    @SafeVarargs
    static List<int[]> getList(int[]...ints) {
        List<int[]> integers = new ArrayList<>();
        for (int[] e : ints) {
            integers.add(e);
        }
        return integers;
    }

}
