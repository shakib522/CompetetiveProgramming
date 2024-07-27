package src.main.kotlin.leetcode;

import java.util.ArrayList;

public class NumberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        int connectionSize=connections.length;
        if (connectionSize<n-1){
            return -1;
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        int componentCount=0;
        for (int i=0;i<n-1;i++){
            if (!vis[i]){
                componentCount++;
                dfs(i,vis,adj);
            }
        }
        return componentCount-1;
    }
    void dfs(int node,boolean[] vis,ArrayList<ArrayList<Integer>>adj){
        vis[node]=true;
        for (Integer adjacent:adj.get(node)){
            if (!vis[adjacent]){
                dfs(adjacent,vis,adj);
            }
        }
    }
}
