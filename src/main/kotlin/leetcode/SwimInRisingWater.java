package src.main.kotlin.leetcode;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInRisingWater {
    class Tuple{
        int maxWt;
        int x;
        int y;
        public Tuple(int maxWt,int x,int y){
            this.maxWt=maxWt;
            this.x=x;
            this.y=y;
        }
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        Comparator<Tuple> comparator = new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o1.maxWt-o2.maxWt;
            }
        };
        PriorityQueue<Tuple> pq = new PriorityQueue<>(comparator);
        int [][] visited = new int[n][n];
        pq.add(new Tuple(grid[0][0], 0, 0));
        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int x=t.x;
            int y=t.y;
            int wt=t.maxWt;
            if (visited[x][y]==1){
                continue;
            }
            visited[x][y]=1;
            if (x==n-1&&y==n-1){
                return wt;
            }
            if (x>0 && visited[x-1][y]==0){
                int currWt=Math.max(wt,grid[x-1][y]);
                pq.add(new Tuple(currWt, x - 1, y));
            }
            if (y>0 && visited[x][y-1]==0){
                int currWt=Math.max(wt,grid[x][y-1]);
                pq.add(new Tuple(currWt, x, y - 1));
            }
            if (x<n-1 && visited[x+1][y]==0){
                int currWt=Math.max(wt,grid[x+1][y]);
                pq.add(new Tuple(currWt, x + 1, y));
            }
            if (y<n-1 && visited[x][y+1]==0){
                int currWt=Math.max(wt,grid[x][y+1]);
                pq.add(new Tuple(currWt, x, y + 1));
            }
        }
        return 0;
    }
}