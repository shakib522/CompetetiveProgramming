package src.main.kotlin.leetcode.top150;

import java.util.ArrayList;
import java.util.List;

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

public class SameTree {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    public boolean isSameTree(TreeNode p, TreeNode q) {
        inOrder(p,list1);
        inOrder(q,list2);
        if (list1.equals(list2)){
            return true;
        }
        return false;
    }
    public void inOrder(TreeNode root,List<Integer>l){
        if (root==null){
            l.add(null);
        }else {
            l.add(root.val);
        }
        if (root==null){
            return;
        }
        inOrder(root.left,l);
        inOrder(root.right,l);
    }
}
