package src.main.kotlin.leetcode.top100

import com.sun.source.tree.Tree


fun isSymmetric(root: TreeNode?): Boolean {
    return check(root?.left,root?.right)
}

fun check(left:TreeNode?,right:TreeNode?):Boolean{
    if (left==null ||  right==null){
        return left==right
    }
    return left.`val` == right.`val` && check(left.left,right.right) && check(left.right,right.left)
}