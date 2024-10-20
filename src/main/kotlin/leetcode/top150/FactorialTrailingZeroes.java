package src.main.kotlin.leetcode.top150;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int ans=0;
        while (n>0){
            n=n/5;
            ans+=n;
        }
        return ans;
    }
}
