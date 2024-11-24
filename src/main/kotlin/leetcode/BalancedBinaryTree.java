package src.main.kotlin.leetcode;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        int f = count(root);
        System.out.println(f);
        if (f==-1){
            return false;
        }
        return f <= 1;
    }

    int count(TreeNode root) {

        if (root.left == null) {
            return 1;
        }
        int left = 1 + count(root.left);
        if (root.right == null) {
            return 1;
        }
        int right = 1 + count(root.right);
        if (left==-1||right==-1){
            return -1;
        }

        if(Math.abs(left - right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
}
