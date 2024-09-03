package src.main.kotlin.leetcode.top100.javaSolution;

public class ConvertedSortedArrayToBinaryTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums,0,nums.length-1);

    }
    public TreeNode createTree(int[] nums,int s,int e ){
        if (s>e){
            return null;
        }
        int mid = s+(e-s)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left=createTree(nums,s,mid-1);
        node.right=createTree(nums,mid+1,e);
        return node;
    }
}
