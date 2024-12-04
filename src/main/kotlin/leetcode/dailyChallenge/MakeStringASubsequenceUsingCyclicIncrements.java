package src.main.kotlin.leetcode.dailyChallenge;

public class MakeStringASubsequenceUsingCyclicIncrements {
    public static void main(String[] args) {
        System.out.println(canMakeSubsequence("zc","ad"));
    }
    public static boolean canMakeSubsequence(String str1, String str2) {
        int p1 = 0;
        int p2 = 0;
        int len1 = str1.length();
        int len2 = str2.length();
        while (p1 < len1 && p2 < len2) {
            int h=(str1.charAt(p1) +1-97) % 26;
            if (str1.charAt(p1) == str2.charAt(p2) || ((char)(h+97)==str2.charAt(p2))) {
                p1++;
                p2++;
            } else {
                p1++;
            }
        }
        return p2 == len2;
    }
}
