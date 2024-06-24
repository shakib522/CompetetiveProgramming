package src.main.kotlin.leetcode.q75

import kotlin.math.max

fun longestZigZag(root: TreeNode?): Int {
    return max(traverse(root,true,0), traverse(root,false,0))
}

fun traverse(root:TreeNode?,left:Boolean,cnt:Int):Int{
    if (root==null){
        return cnt
    }
    if (left){
        if (root.right==null){
            return cnt
        }
        return maxOf( traverse(root.right,false,cnt+1),traverse(root.right,true,0))
    }else{
        if (root.left==null){
            return cnt
        }
       return maxOf( traverse(root.left,true,cnt+1), traverse(root.left,false,0))
    }
}