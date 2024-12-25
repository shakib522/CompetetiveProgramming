package src.main.kotlin.leetcode.dailyChallenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()){
            int len=q.size();
            int max=Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                TreeNode polledItem=q.remove();
                max=Math.max(max,polledItem.val);
                if (polledItem.left!=null) q.add(polledItem.left);
                if (polledItem.right!=null) q.add(polledItem.right);
            }
            ans.add(max);
        }
        return ans;
    }
}
