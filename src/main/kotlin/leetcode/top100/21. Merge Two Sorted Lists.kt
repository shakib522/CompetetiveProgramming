package src.main.kotlin.leetcode.top100

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var ans: ListNode? = ListNode(0)
    var result = ans
    var firstNode = list1
    var secondNode = list2
    while (firstNode != null && secondNode != null) {
        if (firstNode.`val` <= secondNode.`val`) {
            ans?.next = ListNode(firstNode.`val`)
            firstNode = firstNode?.next
            ans = ans?.next
        } else {
            ans?.next = ListNode(secondNode.`val`)
            secondNode = secondNode?.next
            ans = ans?.next
        }
    }
    while (firstNode != null) {
        ans?.next = ListNode(firstNode.`val`)
        firstNode = firstNode?.next
        ans = ans?.next

    }
    while (secondNode != null) {
        ans?.next = ListNode(secondNode.`val`)
        secondNode = secondNode?.next
        ans = ans?.next
    }
    result = result?.next
    return result
}