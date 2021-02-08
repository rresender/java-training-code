package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import org.junit.Test;

public class BalancedBrackets {

    @Test
    public void balancedBrackets() {
//        assertThat(isBalanced("{[()]}"), is(true));
//        assertThat(isBalanced("{[(])}"), is(false));
//        assertThat(isBalanced("{{[[(())]]}}"), is(true));
//        assertThat(isBalanced("{{[[(())]]}}"), is(true));
        
//        (({()})))
//        ({(){}()})()({(){}()})(){()}
//        {}()))(()()({}}{}
//        }}}}
//        ))))
//        {{{
//        (((
//        []{}(){()}((())){{{}}}{()()}{{}{}}
//        [[]][][]
//        }{
        
        assertThat(isBalanced("(({()})))"), is(false));
    }
    
    static boolean isBalanced(String expression) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
//        map.put('<', '>');
        
        List<Character> left = Arrays.asList(new java.lang.Character[] { '{','(', '[', '<' });

        Stack<Character> init = new Stack<>();
        char[] arr = expression.toCharArray();
        boolean first = true;
        for (char c : arr) {
            if (!left.contains(c) && !map.values().contains(c)) {
                continue;
            }
            if (left.contains(c)) {
                init.push(c);
                if (first)
                    first = false;
            } else {
                if (!init.isEmpty()) {
                    char e = map.get(init.peek());
                    if (e != c) {
                        continue;
                    } else {
                        init.pop();
                    }
                }else {
                    return false;
                }
            }
        }
        if (first)
            return false;
        return init.isEmpty();              
    }
    
    
    
    public static void main(String[] args) throws Exception {
        try (FileInputStream is = new FileInputStream(new File("input.txt"));
                     Scanner in = new Scanner(is);
             BufferedReader out = new BufferedReader(new InputStreamReader(new FileInputStream("output.txt")));) {
            System.setIn(is);
            int t = in.nextInt();
            for (int a0 = 0; a0 < t; a0++) {
                String expression = in.next();
                String expected = out.readLine();
                String actual = isBalanced(expression) ? "YES" : "NO";
                if (expected.equals(actual)) {
                    continue;
                }
                System.out.println(expression+" Expected: \n"+expected+" Actual: "+actual);
            }
        }
    }

}
