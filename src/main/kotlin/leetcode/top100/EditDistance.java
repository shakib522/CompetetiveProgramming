package src.main.kotlin.leetcode.top100;

import java.util.Arrays;

public class EditDistance {
    int ans2=Integer.MAX_VALUE;
    public static void main(String[] args) {
        EditDistance e=new EditDistance();
        System.out.println(e.minDistance("horse","ros"));
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp =new int[n+1][m+1];
        for(int [] a:dp){
            Arrays.fill(a,-1);
        }
        return findMemoization(word1,word2,n,m,dp);
    }
    int find(String word1,String word2,int n,int m){
        if (n==0||m==0){
            return n==0 ? m : n;
        }
        if (word1.charAt(n-1)==word2.charAt(m-1)){
            return find(word1,word2,n-1,m-1);
        }else{
            int replace=find(word1,word2,n-1,m-1);
            int delete=find(word1,word2,n-1,m);
            int insert=find(word1,word2,n,m-1);
            return 1+Math.min(replace,Math.min(delete,insert));
        }
    }
    int findMemoization(String word1,String word2,int n,int m,int [][]dp){
        if (n==0||m==0){
            return n==0 ? m : n;
        }
        if (dp[n][m]!=-1){
            return dp[n][m];
        }
        if (word1.charAt(n-1)==word2.charAt(m-1)){
            return findMemoization(word1,word2,n-1,m-1,dp);
        }else{
            int replace=findMemoization(word1,word2,n-1,m-1,dp);
            int delete=findMemoization(word1,word2,n-1,m,dp);
            int insert=findMemoization(word1,word2,n,m-1,dp);
            return dp[n][m]=1+Math.min(replace,Math.min(delete,insert));
        }
    }
}
