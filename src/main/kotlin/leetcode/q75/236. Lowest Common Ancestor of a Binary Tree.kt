package src.main.kotlin.leetcode.q75

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root==null || root==p || root==q ){
        return root
    }
    val left = lowestCommonAncestor(root.left,p,q)
    val right = lowestCommonAncestor(root.right,p,q)
    if (left==null){
        return right
    }
    if (right==null){
        return left
    }
    return root
}