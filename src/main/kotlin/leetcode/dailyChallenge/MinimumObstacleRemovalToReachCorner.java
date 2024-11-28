package src.main.kotlin.leetcode.dailyChallenge;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumObstacleRemovalToReachCorner {
    private static final int[] dir={-1,0,1,0,-1};
    static class Node{
        int r;
        int c;
        int cost;

        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

    }
    static class Compare implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost-o2.cost;
        }
    }
    boolean isValid(int r,int c,int n,int m){
        if(r<0||c<0||r>=n || c>=m){
            return false;
        }
        return true;
    }
    public int minimumObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());
        pq.offer(new Node(0,0,grid[0][0]));
        boolean[][] vis=new boolean[n][m];
        vis[0][0]=true;
        int cnt=0;
        while (!pq.isEmpty()){
            Node node = pq.poll();
            cnt=node.cost;
            if (node.r==n-1 && node.c==m-1){
                return cnt;
            }
            for (int i = 0; i < 4; i++) {
                int r=node.r+dir[i];
                int c=node.c+dir[i+1];
                if (isValid(r,c,n,m) && !vis[r][c]){
                    int val=grid[r][c];
                    pq.offer(new Node(r,c,val+cnt));
                    vis[r][c]=true;
                }
            }
        }
        return cnt;
    }
}
