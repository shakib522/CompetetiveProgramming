package src.main.kotlin.leetcode.contest.weekly422;

public class FindMinimumTimetoReachLastRoom1 {
//    public int minTimeToReach(int[][] moveTime) {
//
//    }
    int helper(int[][] moveTime,int i,int j){
        int time=moveTime[i][j]+1;
        int left=helper(moveTime,i,j-1);
        int right=helper(moveTime,i,j-1);
        int up=helper(moveTime,i-1,j);
        int down=helper(moveTime,i+1,j);
        return time+up+down+right+left;
    }
}
