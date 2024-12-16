package src.main.kotlin.leetcode;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        char ch='A';
        System.out.println(ch);
    }

    public int characterReplacement(String s, int k) {
        int ans = 0;
        int n = s.length();
        for (char c = 'A'; c <= 'Z'; c++) {
            int i = 0, j = 0, replace = 0;
            while (j < n) {
                if (s.charAt(j) == c) {
                    j++;
                } else if (replace < k) {
                    j++;
                    replace++;
                } else if (s.charAt(i) == c) {
                    i++;
                } else {
                    i++;
                    replace--;
                }
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }
}
