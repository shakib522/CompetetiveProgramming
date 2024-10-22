package src.main.kotlin.leetcode.top150;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsValue(t.charAt(i)) && !map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            builder.append(map.get(s.charAt(i)));
        }
        return builder.toString().equals(t);

    }

    public static boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] ara1 = new int[200];
        int[] ara2 = new int[200];
        for (int i=0;i<s.length();i++){
            if (ara1[s.charAt(i)]!=ara2[t.charAt(i)]){
                return false;
            }
            ara1[s.charAt(i)]=i+1;
            ara2[t.charAt(i)]=i+1;
        }
        return true;
    }
}
