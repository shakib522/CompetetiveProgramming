package src.main.kotlin.leetcode.q75


fun append(head: ListNode?, item: Int): ListNode {
    var currentNode: ListNode? = head

    val newNode = ListNode(item)
    if (head == null) {
        return newNode
    }
    while (currentNode?.next != null) {
        currentNode = currentNode.next
    }
    currentNode?.next = newNode
    return head
}

fun reverseList(head: ListNode?): ListNode? {
    if(head==null){
        return null
    }
    var currNode = head
    val array = mutableListOf<Int>()
    while (currNode != null) {
        array.add(currNode.valu)
        currNode=currNode.next
    }
    var temp:ListNode? = ListNode(array[array.size-1])
    for (i in array.size-2 downTo  0) {
        append(temp, array[i])
    }
    return temp
}