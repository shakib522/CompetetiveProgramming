package src.main.kotlin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MostStonesRemovedWithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        Disjoint dsu = new Disjoint(stones.length);
        for (int i = 0; i < stones.length - 1; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    dsu.unionByRank(i, j);
                }
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = stones.length;
        int[] hash = new int[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int parent = dsu.findParent(i);
            hash[parent]++;
        }
        for (int i = 0; i < len; i++) {
            if (hash[i] > 1) {
                ans += (hash[i] - 1);
            }
        }
        return ans;
    }
}

class Disjoint {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public Disjoint(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }

    void unionByRank(int u, int v) {
        int ultimateU = findParent(u);
        int ultimateV = findParent(v);
        if (ultimateV == ultimateU) {
            return;
        }
        if (rank.get(ultimateV) < rank.get(ultimateU)) {
            parent.set(ultimateV, ultimateU);
        } else if (rank.get(ultimateV) > rank.get(ultimateU)) {
            parent.set(ultimateU, ultimateV);
        } else {
            //add v to u
            parent.set(ultimateV, ultimateU);
            int rankOfU = rank.get(ultimateU);
            rank.set(ultimateU, rankOfU + 1);
        }
    }
}
