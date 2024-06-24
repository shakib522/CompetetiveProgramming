package src.main.kotlin.leetcode.q75


fun goodNodes(root: TreeNode?): Int {
    if (root == null) return 0
    return inOrderTraversal(root, root.`val`,0)
}

fun inOrderTraversal(root: TreeNode?, max: Int,cnt:Int):Int {
    var x=0
    if (root == null) return x

    val newMax = maxOf(root.`val`, max)
    if (root.left != null) {
        x+=inOrderTraversal(root.left, newMax,x)
    }
    if (root.`val` >= newMax) {
        x++
    }
    if (root.right != null) {
        x+= inOrderTraversal(root.right, newMax,x)
    }
    return x
}
