package src.main.kotlin.leetcode.top150;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABST {
    int cnt = 0;
    int ans=0;
    public int kthSmallest(TreeNode root, int k) {
        inOrderOptimized(root, k);
        return ans;
    }

    void inOrderOptimized(TreeNode head, int k) {
        if (head.left != null) {
             inOrderOptimized(head.left, k);
        }
        cnt++;
        if (cnt == k) {
            ans=head.val;
        }
        if (head.right != null) {
            inOrderOptimized(head.right, k);
        }
    }

    void inOrder(TreeNode head, List<Integer> l) {
        if (head.left != null) {
            inOrder(head.left, l);
        }
        l.add(head.val);
        if (head.right != null) {
            inOrder(head.right, l);
        }
    }
}
