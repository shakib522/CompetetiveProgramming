package src.main.kotlin.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length - 1;
        int[] color = new int[n+1];
        Arrays.fill(color, -1);
        for (int i = 0; i <= n; i++) {
            if (color[i] == -1) {
                if(!check(graph, i, color)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean check(int[][] graph, int parent, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(parent);
        color[parent] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int adjacent : graph[node]) {
                if (color[adjacent] == -1) {
                    if (color[node] == 0) {
                        color[adjacent] = 1;
                    } else {
                        color[adjacent] = 0;
                    }
                    q.add(adjacent);
                } else if (color[adjacent] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}