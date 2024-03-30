package src.main.kotlin.leetcode.q75

fun main() {

}

fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
    if (root == null) {
        return null
    }
    if (root.`val` > key) {
        root.left = deleteNode(root.left, key)
        return root
    } else if (root.`val` < key) {
        root.right = deleteNode(root.right, key)
        return root
    }
    if (root.left == null) {
        return root.right
    } else if (root.right == null) {
        return root.left
    } else {
        var successorParent = root
        var successor = root.right
        while (successor?.left != null) {
            successorParent = successor
            successor = successor.left
        }
        if (successorParent != root) {
            successorParent?.left = successor?.right
        } else {
            successorParent.right = successor?.right
        }
        successor?.let {
            root.`val` = it.`val`
        }
        return root
    }
}