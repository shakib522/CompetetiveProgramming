package src.main.kotlin.leetcode.top100


fun main() {

}

fun isValidBST(root: TreeNode?): Boolean {
    return check(root,Long.MIN_VALUE,Long.MAX_VALUE)
}

fun check(node:TreeNode?,low:Long,high:Long):Boolean{
    if (node==null){
        return true
    }
    if (node.`val`<=low||node.`val`>=high){
        return false
    }
    return check(node.left,low,node.`val`.toLong()) && check(node.right,node.`val`.toLong(),high)
}