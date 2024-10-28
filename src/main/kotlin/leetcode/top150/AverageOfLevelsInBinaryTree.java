package src.main.kotlin.leetcode.top150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Double> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int l = queue.size();
            long sum = 0;
            for (int i = 0; i < l; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sum += node.val;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            double res=sum/(double)l;
            ans.add(res);
        }
        return ans;
    }
}
