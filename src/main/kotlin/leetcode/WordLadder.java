package src.main.kotlin.leetcode;

import src.main.kotlin.Pair;

import java.util.*;
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(beginWord, 1));
        Set<String> set = new HashSet<>();
        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().getFirst();
            int steps = q.peek().getSecond();
            q.remove();
            if (word.equals(endWord)) return steps;

            for (int i=0;i<word.length();i++){
                for (char ch = 'a';ch<='z';ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord = new String(replacedCharArray);
                    if (set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(new Pair<>(replacedWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
