package src.main.kotlin.leetcode.dailyChallenge;

public class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        int[] suffixMax = new int[len];
        suffixMax[len - 1] = values[len - 1] - (len - 1);
        for (int i = len - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(values[i] - i, suffixMax[i + 1]);
        }
        int score = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            score = Math.max(values[i] + i + suffixMax[i + 1], score);
        }
        return score;
    }

    public int maxScoreSightseeingPair2(int[] values) {
        int len = values.length;
        int m = values[0];
        int score = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            if (values[i] - i + m > score) {
                score = values[i] - i + m;
            }
            if (values[i] + i > m) {
                m = values[i] + i;
            }
        }
        return score;
    }
}
