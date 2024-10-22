package src.main.kotlin.leetcode.top150;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] ara=s.split(" ");
        if(ara.length!=pattern.length()){
            return false;
        }
        Map<Character,String> map = new HashMap<>();
        for (int i=0;i<pattern.length();i++){
            if (map.containsKey(pattern.charAt(i))){
                if (!map.get(pattern.charAt(i)).equals(ara[i])){
                    return false;
                }
            }else if (map.containsValue(ara[i])){
                return false;
            }else{
                map.put(pattern.charAt(i),ara[i]);
            }
        }
        return true;
    }
}
