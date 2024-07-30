package src.main.kotlin.leetcode;

import java.util.Arrays;

public class  CheapestFlightsWithinKStops
{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(dis,n);
            for (int[] edge : flights) {
                int u = edge[0];
                int v = edge[1];
                int cost = edge[2];
                if (dis[u] != Integer.MAX_VALUE && dis[u] + cost < temp[v]) {
                    temp[v]=dis[u]+cost;
                }
            }
            dis=temp;
        }
        if (dis[dst]==Integer.MAX_VALUE){
            return -1;
        }else{
            return dis[dst];
        }
    }
}
