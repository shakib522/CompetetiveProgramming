package src.main.kotlin.leetcode.dailyChallenge;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumTimeToVisitACellInAGrid {
    private static final int[] dir={-1,0,1,0,-1};
    static class Node{
        int r;
        int c;
        int time;
        Node(int r,int c,int time){
            this.r=r;
            this.c=c;
            this.time=time;
        }
    }
    static class Compare implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.time-o2.time;
        }
    }
    public boolean isValid(int n,int m,int r,int c){
        return r < n && c < m && r >= 0 && c >= 0;
    }
    public int minimumTime(int[][] grid) {
        if (grid[0][1]>1 && grid[1][0]>1){
            return -1;
        }
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        PriorityQueue<Node> pq=new PriorityQueue<>(new Compare());
        pq.add(new Node(0,0,0));
        vis[0][0]=true;
        int time=0;
        while (!pq.isEmpty()){
            Node node=pq.poll();
            if (node.r==n-1 && node.c==m-1){
                time=node.time;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int row=node.r+dir[i];
                int col=node.c+dir[i+1];
                if (isValid(n,m,row,col) && !vis[row][col]){
                    vis[row][col]=true;
                    if (grid[row][col]>node.time+1){
                        int diff=grid[row][col]-node.time;
                        if ((diff&1)==0){
                            diff++;
                        }
                        pq.add(new Node(row,col,diff+node.time));
                    }else{
                        pq.add(new Node(row,col,node.time+1));
                    }
                }
            }
        }
        return time;
    }
}
