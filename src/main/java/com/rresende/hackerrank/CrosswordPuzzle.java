package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class CrosswordPuzzle {

    @Test
    public void crosswordPuzzle() {
        assertThat(crosswordPuzzle(new String[] {"+-++++++++","+-------++","+-++-+++++","+-------++","+-++-++++-","+-++-++++-","+-++------","+++++++++-","++++++++++","++++++++++"}, "ANDAMAN;MANIPUR;ICELAND;ALLEPY;YANGON;PUNE"), is(new String[] {"+M++++++++","+ANDAMAN++","+N++L+++++","+ICELAND++","+P++E++++P","+U++P++++U","+R++YANGON","+++++++++E","++++++++++","++++++++++"}));
        assertThat(crosswordPuzzle(new String[] {"+-++++++++","+-++++++++","+-------++","+-++++++++","+-----++++","+-+++-++++","+++-----++","+++++-++++","+++++-++++","+++++-++++"},"SYDNEY;TURKEY;DETROIT;EGYPT;PARIS"), is(new String[] {"+S++++++++","+Y++++++++","+DETROIT++","+N++++++++","+EGYPT++++","+Y+++U++++","+++PARIS++","+++++K++++","+++++E++++","+++++Y++++"}));
        assertThat(crosswordPuzzle(new String[] {"+-++++++++","+-++-+++++","+-------++","+-++-+++++","+-++-+++++","+-++-+++++","++++-+++++","++++-+++++","++++++++++", "----------"},"CALIFORNIA;NIGERIA;CANADA;TELAVIV"), is(new String[] {"+C++++++++","+A++T+++++","+NIGERIA++","+A++L+++++","+D++A+++++","+A++V+++++","++++I+++++","++++V+++++","++++++++++","CALIFORNIA"}));
        assertThat(crosswordPuzzle(new String[] { "+-++++++++", "+-++++++++", "+-++++++++", "+-----++++", "+-+++-++++", "+-+++-++++", "+++++-++++", "++------++", "+++++-++++", "+++++-++++" },"LONDON;DELHI;ICELAND;ANKARA"), is(new String[] { "+L++++++++", "+O++++++++", "+N++++++++", "+DELHI++++", "+O+++C++++", "+N+++E++++", "+++++L++++", "++ANKARA++", "+++++N++++", "+++++D++++" }));
        assertThat(crosswordPuzzle(new String[] { "++++++++++", "+------+++", "+++-++++++", "+++-++++++", "+++-----++", "+++-++-+++", "++++++-+++", "++++++-+++", "++++++-+++", "++++++++++" },"POLAND;LHASA;SPAIN;INDIA"), is(new String[] {"++++++++++","+POLAND+++","+++H++++++","+++A++++++","+++SPAIN++","+++A++N+++","++++++D+++","++++++I+++","++++++A+++","++++++++++"}));
        assertThat(crosswordPuzzle(new String[] {"+-++++++++","+-++++++++","+-------++","+-++++++++","+-++++++++","+------+++","+-+++-++++","+++++-++++","+++++-++++","++++++++++"},"AGRA;NORWAY;ENGLAND;GWALIOR"), is(new String[] {"+E++++++++","+N++++++++","+GWALIOR++","+L++++++++","+A++++++++","+NORWAY+++","+D+++G++++","+++++R++++","+++++A++++","++++++++++"}));
    }
    
    static String[] crosswordPuzzle(String[] crossword, String words) {
        int n = crossword.length;
        String[] arr = words.split(";");
        boolean solved = false;
        int i = 0;
        String[] clone = crossword.clone();
        while (!solved && i < arr.length) {
            for (String word : arr) {
                System.out.println(word);
                solve(word, crossword, n);
                print(crossword);
            }
        
            for (String s : crossword) {
                if(s.contains("-")){
                   solved = false;
                   System.arraycopy(clone, 0, crossword, 0, crossword.length);
                   break;
                }
                solved = true;
            }
        
            String temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
            i++;
        }
    
        return crossword;
    }

    private static void print(String[] crossword) {
        for (int i = 0; i < crossword.length; i++) {
            System.out.println(String.valueOf(crossword[i]));
        }
        System.out.println();
    }
   
    static void solve(String word, String[] crossword, int n) {
        String[] clone = crossword.clone();
        int maxLen = n - word.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxLen; j++) {
                
                if (vertical(j, i, crossword, word))
                    return;

                System.arraycopy(clone, 0, crossword, 0, crossword.length);
                
                if (horizontal(i, j, crossword, word))
                    return;
                
                System.arraycopy(clone, 0, crossword, 0, crossword.length);
            }
        }
    }

    static boolean horizontal(int x, int y, String[] crossword, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (crossword[x].charAt(y + i) == '-' || crossword[x].charAt(y + i) == word.charAt(i)) {
                setChar(x, y + i, crossword, word, i);
            } else {
                return false;
            }
        }
        int i = y + word.length();
        if (i < crossword.length && crossword[x].charAt(i) == '-')
            return false;
        
        if (y > 0 && (crossword[x].charAt(y-1) == '-' || crossword[x].charAt(y-1) != word.charAt(0))) {
            if (crossword[x].charAt(y-1) == '+' || crossword[x].charAt(y-1) == 'X') {
                return true;
            } 
            return false;
        }
        
        return true;
    }

    static boolean vertical(int x, int y, String[] crossword, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (crossword[x + i].charAt(y) == '-' || crossword[x + i].charAt(y) == word.charAt(i)) {
                setChar(x + i, y, crossword, word, i);
            } else {
                return false;
            }
        }
        int i = x + word.length();
        if (i < crossword.length && crossword[i].charAt(y) == '-' ||
                crossword[x > 0 ? x-1 : 0 ].charAt(y) == '-') {
            return false;
        }
        
        return true;
    }

    private static void setChar(int x, int y, String[] crossword, String word, int i) {
        char[] a = crossword[x].toCharArray();
        a[y] = word.charAt(i);
        crossword[x] = String.valueOf(a);
    }

}
    