package src.main.kotlin.leetcode.q75;

import java.util.ArrayDeque;
import java.util.Queue;

class TreeNod {
    int val;
    TreeNod left;
    TreeNod right;

    TreeNod() {
    }

    TreeNod(int val) {
        this.val = val;
    }

    TreeNod(int val, TreeNod left, TreeNod right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class MaximumLevelSumOfABinaryTree {


    public int maxLevelSum(TreeNod root) {
        Queue<TreeNod> q = new ArrayDeque<>();
        q.add(root);
        int ans = Integer.MIN_VALUE;
        int level = 1;
        int ansl = 1;
        while (!q.isEmpty()) {
            int l = q.size();
            int sum = 0;
            for (int i = 0; i < l; i++) {
                TreeNod node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            if (sum > ans) {
                ans = sum;
                ansl = level;
            }
            level++;
        }
        return ansl;
    }
}