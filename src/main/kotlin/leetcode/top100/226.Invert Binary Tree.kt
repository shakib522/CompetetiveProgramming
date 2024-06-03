package src.main.kotlin.leetcode.top100

fun invertTree(root: TreeNode?): TreeNode? {
    val deque = ArrayDeque<TreeNode?>()
    deque.addFirst(root)
    while (deque.isNotEmpty()) {
        val f = deque.removeFirst()
        val temp = f?.right
        f?.right = f?.left
        f?.left = temp
        if (f?.left != null) {
            deque.addLast(f.left)
        }
        if (f?.right != null) {
            deque.addLast(f.right)
        }
    }
    return root
}