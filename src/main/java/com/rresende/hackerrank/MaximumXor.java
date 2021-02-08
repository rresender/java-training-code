package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class MaximumXor {

    @Test
    public void maxXor() {
        assertThat(maxXor(new int[] { 0, 1, 2 }, new int[] { 3, 7, 2 }), is(new int[] { 3, 7, 3 }));
        assertThat(maxXor(new int[] { 5, 1, 7, 4, 3 }, new int[] { 2, 0 }), is(new int[] { 7, 7 }));
        assertThat(maxXor(new int[] { 1, 3, 5, 7 }, new int[] { 17, 6 }), is(new int[] { 22, 7 }));
    }

    static int INT_SIZE = 32;

    static class TrieNode {
        final TrieNode[] children = new TrieNode[2];
        int value;
    }

    static TrieNode root;

    static void insert(int pre_xor) {
        TrieNode temp = root;
        for (int i = INT_SIZE - 1; i >= 0; i--) {
            int val = (pre_xor & (1 << i)) >= 1 ? 1 : 0;
            if (temp.children[val] == null)
                temp.children[val] = new TrieNode();
            temp = temp.children[val];
        }
        temp.value = pre_xor;
    }

    static int query(int xor) {
        TrieNode temp = root;
        for (int i = INT_SIZE - 1; i >= 0; i--) {
            int val = (xor & (1 << i)) >= 1 ? 1 : 0;
            if (temp.children[1 - val] != null)
                temp = temp.children[1 - val];
            else if (temp.children[val] != null)
                temp = temp.children[val];
        }
        return xor ^ (temp.value);
    }

    static void setupTrie(int arr[]) {
        root = new TrieNode();
        insert(0);
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    static int[] maxXor(final int[] arr, final int[] queries) {
        final int[] r = new int[queries.length];
        setupTrie(arr);
        for (int i = 0; i < queries.length; i++) {
            r[i] = query(queries[i]);
        }
        return r;
    }
}
