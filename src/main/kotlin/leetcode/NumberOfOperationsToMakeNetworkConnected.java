package src.main.kotlin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected {
//    public int makeConnected(int n, int[][] connections) {
//        int connectionSize = connections.length;
//        if (connectionSize < n - 1) {
//            return -1;
//        }
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            adj.add(new ArrayList<>());
//        }
//        for (int[] connection : connections) {
//            int u = connection[0];
//            int v = connection[1];
//            adj.get(u).add(v);
//            adj.get(v).add(u);
//        }
//        boolean[] vis = new boolean[n];
//        int componentCount = 0;
//        for (int i = 0; i < n - 1; i++) {
//            if (!vis[i]) {
//                componentCount++;
//                dfs(i, vis, adj);
//            }
//        }
//        return componentCount - 1;
//    }

    public int makeConnected(int n, int[][] connections) {
        //solve using dsu
        int connectionSize = connections.length;
        if (connectionSize < n - 1) {
            return -1;
        }
        DSU dsu = new DSU(n);
        for (int[] connection:connections){
            dsu.unionByRank(connection[0],connection[1]);
        }
        int component=0;
        for (int i=0;i<n;i++){
            if(dsu.findParent(i)==i){
                component++;
            }
        }
        return component-1;
    }

    void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        for (Integer adjacent : adj.get(node)) {
            if (!vis[adjacent]) {
                dfs(adjacent, vis, adj);
            }
        }
    }
}

class DSU {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DSU(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int ultimateParentOfU = findParent(u);
        int ultimateParentOfV = findParent(v);
        if (ultimateParentOfV==ultimateParentOfU){
            return;
        }
        if (rank.get(ultimateParentOfU)<rank.get(ultimateParentOfV)){
            parent.set(ultimateParentOfU,ultimateParentOfV);
        }else if (ultimateParentOfV<ultimateParentOfU){
            parent.set(ultimateParentOfV,ultimateParentOfU);
        }else{
            parent.set(ultimateParentOfU,ultimateParentOfV);
            int rankU=rank.get(ultimateParentOfV);
            rank.set(ultimateParentOfV,rankU+1);
        }
    }
}