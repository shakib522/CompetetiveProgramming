package src.main.kotlin.leetcode.contest.weekly422;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMinimumTimetoReachLastRoom1 {
    private static final int[] dir={-1,0,1,0,-1};
    static class Node{
        int r;
        int c;
        int time;

        public Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }

    }
    static class Compare implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o1.time-o2.time;
        }
    }
    boolean isValid(int r,int c,int n,int m){
        if(r<0||c<0||r>=n || c>=m){
            return false;
        }
        return true;
    }
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length;
        int m=moveTime[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());
        pq.offer(new Node(0,0,0));
        boolean[][] vis=new boolean[n][m];
        vis[0][0]=true;
        while (!pq.isEmpty()){
            Node node=pq.poll();
            if(node.r==n-1&&node.c==m-1){
                return node.time;
            }
            for (int i=0;i<4;i++){
                int r=node.r+dir[i];
                int c=node.c+dir[i+1];
                if (isValid(r,c,n,m)&&!vis[r][c]){
                    int val= Math.max(node.time,moveTime[r][c])+1;
                    pq.offer(new Node(r,c,val));
                    vis[r][c]=true;
                }
            }
        }
        return 0;
    }
}
