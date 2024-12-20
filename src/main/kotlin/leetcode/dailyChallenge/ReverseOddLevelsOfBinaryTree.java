package src.main.kotlin.leetcode.dailyChallenge;


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

public class ReverseOddLevelsOfBinaryTree {
    public void swap(TreeNode node1,TreeNode node2){
        int val= node1.val;
        node1.val= node2.val;
        node2.val=val;
    }
    public void recurse(TreeNode node1,TreeNode node2,int level){
        if (node1==null || node2==null){
            return;
        }
        if ((level&1)==1){
            swap(node1,node2);
        }
        recurse(node1.left,node2.right,level+1);
        recurse(node1.right,node2.left,level+1);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        recurse(root.left,root.right,1);
        return root;
    }
}
