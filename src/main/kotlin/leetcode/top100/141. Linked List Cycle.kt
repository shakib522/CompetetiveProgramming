package src.main.kotlin.leetcode.top100

import src.main.kotlin.leetcode.q75.ListNode


fun hasCycle(head: ListNode?): Boolean {
    var curNode = head
    while (curNode != null) {
        if (curNode.valu==Int.MAX_VALUE){
            return true
        }
        curNode.valu = Int.MAX_VALUE
        curNode = curNode.next
    }
    return false
}