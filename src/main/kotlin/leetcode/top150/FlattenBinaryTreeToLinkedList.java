package src.main.kotlin.leetcode.top150;

import java.util.ArrayDeque;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList {
    Queue<TreeNode> q = new ArrayDeque<>();

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            node.right = q.peek();
            node.left = null;
        }
    }

    void preOrder(TreeNode root) {
        q.add(root);
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    public void flatten2(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode left = cur.left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = cur.right;
                cur.right = cur.left;
                cur.left=null;
            }
            cur = cur.right;
        }
    }
}


















