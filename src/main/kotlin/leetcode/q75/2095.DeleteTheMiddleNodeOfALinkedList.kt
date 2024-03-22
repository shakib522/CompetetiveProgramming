package src.main.kotlin.leetcode.q75

import src.main.kotlin.leetcode.q75.addTwoNumbers

class ListNode(var valu: Int) {
    var next: ListNode? = null
    fun counting(head: ListNode?): Int {
        var len = 0
        var currentNode = head
        while (currentNode != null) {
            len++
            currentNode = currentNode.next
        }
        return len
    }

    fun printList(head: ListNode?) {
        var currentNode = head
        while (currentNode != null) {
            println(currentNode.valu)
            currentNode = currentNode.next
        }
    }

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
}

fun main() {
    var head:ListNode? = ListNode(9)
    var head2:ListNode? = ListNode(1)
    head2?.append(head2,9)
    head2?.append(head2,9)
    head2?.append(head2,9)
    head2?.append(head2,9)
    head2?.append(head2,9)
    head2?.append(head2,9)
    head2?.append(head2,9)
    head2?.append(head2,9)
    head2?.append(head2,9)
//    head?.append(head,3)
//    head?.append(head,6)
      val newHead= src.main.kotlin.leetcode.q75.addTwoNumbers(head, head2)
    newHead?.printList(newHead)
//    println("counting${head?.counting(head)}")
//    head=deleteMiddle(head)
//    println("counting:")
//    println(head?.counting(head))
//    println("printing")
//    head?.printList(head)
}

fun deleteMiddle(head: ListNode?): ListNode? {
    val len = head?.counting(head)
    val loop = len?.div(2)
    var currentNode = head
    if(len==1){
        return null
    }
    if (loop != null) {
        for (i in 0..<loop-1 ){
            currentNode = currentNode?.next
        }
    }
    currentNode?.next = currentNode?.next?.next
    return head
}