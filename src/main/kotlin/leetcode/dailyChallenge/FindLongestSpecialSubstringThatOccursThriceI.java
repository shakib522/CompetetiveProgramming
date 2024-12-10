package src.main.kotlin.leetcode.dailyChallenge;

import java.util.Arrays;

public class FindLongestSpecialSubstringThatOccursThriceI {
    private int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
    public int maximumLength(String s) {
        int[][] top3Freq = new int[26][3];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(top3Freq[i], -1);
        }
        char lastSeen = '*';
        int windowLen = 0;

        for (char cur : s.toCharArray()) {
            int index = cur - 'a';
            if (cur == lastSeen) {
                windowLen++;
            } else {
                windowLen = 1;
            }
            lastSeen = cur;
            int minIndex = 0;
            for (int j = 1; j < 3; j++) {
                if (top3Freq[index][j] < top3Freq[index][minIndex]) {
                    minIndex = j;
                }
            }
            if (windowLen > top3Freq[index][minIndex]) {
                top3Freq[index][minIndex] = windowLen;
            }
        }
        int maxLen = -1;
        for (int i = 0; i < 26; i++) {
            maxLen = Math.max(maxLen, getMin(top3Freq[i][0], top3Freq[i][1], top3Freq[i][2]));
        }
        return maxLen;
    }
}
