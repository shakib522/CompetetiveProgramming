package src.main.kotlin.leetcode.q75;

public class MinimumFlipstoMakeaORbEqualtoc {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        while ((a | b) != c) {
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;
            if ((bitA | bitB) != bitC) {
                if (bitA == 1 && bitB == 1) {
                    ans += 2;
                } else {
                    ans++;
                }
            }
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        return ans;
    }
}
