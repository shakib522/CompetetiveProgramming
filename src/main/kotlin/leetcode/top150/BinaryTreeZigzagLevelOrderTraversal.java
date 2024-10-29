package src.main.kotlin.leetcode.top150;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null){
            return ans;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int cnt=1;
        while (!q.isEmpty()){
            int l=q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < l; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left!=null){
                    q.add(node.left);
                }
                if (node.right!=null){
                    q.add(node.right);
                }
            }
            if ((cnt&1)==0){
                Collections.reverse(list);
            }
            ans.add(list);
            cnt++;
        }
        return ans;
    }
}
