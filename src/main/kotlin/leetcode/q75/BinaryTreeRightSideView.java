package src.main.kotlin.leetcode.q75;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNd root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNd> temp = new LinkedList<>();
        temp.add(root);
        while (!temp.isEmpty()){
            int l=temp.size();
            int val=0;
            for (int i=0;i<l;i++){
                TreeNd node =temp.poll();
                val=node.val;
                if (node.left!=null) temp.add(node.left);
                if (node.right!=null) temp.add(node.right);
            }
            ans.add(val);
        }
        return ans;
    }
}

class TreeNd {
    public int val;
    public TreeNd left;
    public TreeNd right;

    public TreeNd() {
    }

    public TreeNd(int val) {
        this.val = val;
    }

    public TreeNd(int val, TreeNd left, TreeNd right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
