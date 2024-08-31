package src.main.kotlin.leetcode.top150;

import java.util.*;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return Integer.compare(o1.length(), o2.length());
                }
                return o1.compareTo(o2);
            }
        });
        ArrayList<Character> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            cnt = 0;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].isEmpty()) {
                    cnt = 1;
                    break;
                }
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    cnt = 1;
                    break;
                }
            }
            if (cnt == 0) {
                list.add(strs[0].charAt(i));
            } else {
                break;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Character s : list) {
            ans.append(s);
        }
        return ans.toString();
    }
}