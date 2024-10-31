package src.main.kotlin.leetcode.q75;

import java.util.Arrays;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        MinCostClimbingStairs min=new MinCostClimbingStairs();
        System.out.println(min.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
    public int minCostClimbingStairs(int[] cost) {
        int len=cost.length;
        int [] dp = new int[len];
        Arrays.fill(dp,-1);
        if (len==2){
            return Math.min(cost[1],cost[0]);
        }
        return helper(cost,len-1,dp);
    }
    int helper(int[] cost,int index,int[] dp){
        if(index==0){
            return cost[0];
        }
        if (dp[index]!=-1){
            return dp[index];
        }
        int left=Integer.MAX_VALUE;
        if (index==1){
            left=cost[1];
        }else{
            left=helper(cost,index-1,dp);
        }
        if (index!=cost.length-1&& index!=1){
            left+=cost[index];
        }
        int right=Integer.MAX_VALUE;
        if (index>1){
            right=cost[index]+helper(cost,index-2,dp);
        }
        return dp[index]=Math.min(left,right);
    }
    int helperDpIterative(int[] cost,int index,int[] dp){
        if(index==0){
            return cost[0];
        }
        int prev=cost[1];
        int prev2=cost[0];
        for (int i = 0; i < index; i++) {
            int left;
            if (index==1){
                left=cost[1];
            }else{
                left=cost[index-1];
            }
            if (index!=cost.length-1&& index!=1){
                left+=cost[index];
            }
            int right=Integer.MAX_VALUE;
            if (index>1){
                right=cost[index]+helper(cost,index-2,dp);
            }
        }

        return dp[index];
    }
}