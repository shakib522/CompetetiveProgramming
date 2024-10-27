package src.main.kotlin.leetcode.top150;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs stairs = new ClimbingStairs();
        System.out.println(stairs.climbStairs(45));
        System.out.println(stairs.climbStairsTabular(45));
    }
    public int climbStairs(int n) {
       int [] ara = new int[n+1];
        Arrays.fill(ara,-1);
        return helper(n,ara);
    }
    public int helper(int n,int[] ara){
        if (n==1||n==0){
            return 1;
        }
        if (ara[n]!=-1){
            return ara[n];
        }
        return ara[n]=helper(n-1,ara)+helper(n-2,ara);
    }
    public int climbStairsTabular(int n) {
        int prev2=0;
        int prev1=1;
        for (int i=1;i<=n;i++){
            int cnt=prev1+prev2;
            prev2=prev1;
            prev1=cnt;
        }
        return prev1;
    }
}
