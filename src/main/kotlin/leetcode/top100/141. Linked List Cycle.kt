package src.main.kotlin.leetcode.top100


fun hasCycle(head: ListNode?): Boolean {
    var curNode = head
    while (curNode != null) {
        if (curNode.`val`==Int.MAX_VALUE){
            return true
        }
        curNode.`val` = Int.MAX_VALUE
        curNode = curNode.next
    }
    return false
}