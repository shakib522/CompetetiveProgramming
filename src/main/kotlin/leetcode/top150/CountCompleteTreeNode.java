package src.main.kotlin.leetcode.top150;

public class CountCompleteTreeNode {
    int cnt=0;
    public int countNodes(TreeNode root) {
        dfs(root);
        return cnt;
    }
    void dfs(TreeNode root){
        cnt++;
        if (root.left!=null){
            dfs(root.left);
        }
        if (root.right!=null){
            dfs(root.right);
        }
    }
}
