package src.main.kotlin.leetcode.dailyChallenge;


import java.util.HashMap;
import java.util.Map;

public class SlidingPuzzle {
    public static void main(String[] args) {
        SlidingPuzzle puzzle=new SlidingPuzzle();
        int ans=puzzle.slidingPuzzle(new int[][]{
                {1,0,3},
                {4,2,5}
        });
        System.out.println(ans);
    }
    private final int[][] dir={
            {1,3},
            {0,2,4},
            {1,5},
            {0,4},
            {3,5,1},
            {2,4}
    };
    public int slidingPuzzle(int[][] board) {
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                builder.append(board[i][j]);
            }
        }
        Map<String,Integer> visited =new HashMap<>();
        dfs(builder.toString(),visited,builder.toString().indexOf("0"),0);
        return visited.getOrDefault("123450",-1);
    }

    private void dfs(String state, Map<String, Integer> visited, int zeroIndex, int moves) {
        if(visited.containsKey(state) && visited.get(state)<=moves){
            return;
        }
        visited.put(state,moves);
        for(int dir:dir[zeroIndex]){
            String newState=swap(state,zeroIndex,dir);
            dfs(newState,visited,dir,moves+1);
        }
    }
    private String swap(String s,int i,int j){
        StringBuilder builder=new StringBuilder(s);
        builder.setCharAt(i,s.charAt(j));
        builder.setCharAt(j,s.charAt(i));
        return builder.toString();
    }
}
