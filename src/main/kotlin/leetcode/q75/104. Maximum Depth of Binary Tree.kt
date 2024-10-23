package src.main.kotlin.leetcode.q75

import kotlin.math.max

fun main() {

}


public class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class SolutionOf {
    var ans = 0
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        postOrder(root, 1)
        return ans
    }

    fun postOrder(root: TreeNode?, level: Int) {
        if (root?.left != null) {
            postOrder(root.left, level + 1)
        }
        if (root?.right != null) {
            postOrder(root.right, level + 1)
        }
        ans = max(ans, level)
    }
}