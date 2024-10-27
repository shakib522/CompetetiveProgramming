package src.main.kotlin.leetcode

import src.main.kotlin.leetcode.q75.ListNode

fun main(){
    val head=ListNode(2)
    head.next=ListNode(1)
    head.next?.next=ListNode(1)
    head.next?.next?.next=ListNode(2)
    println(isPalindromeRecursive(head,head))
    isPalindrome(head)
}
fun printLinkedList(head:ListNode?){
    var currentNode=head
    while (currentNode !=null){
        println("${currentNode.valu} ")
        currentNode=currentNode.next
    }
    println()
}
var cur:ListNode?=null
fun isPalindromeRecursive(curNode:ListNode?,head:ListNode?):Boolean{
    cur=head
    if (curNode==null){
        return true
    }
    val res= isPalindromeRecursive(curNode.next,head)
    val temp= cur?.valu
    cur=cur?.next
    return (temp==curNode.valu ) && res
}

fun isPalindrome(head: ListNode?): Boolean {
    var p1=head
    var p2=head
    while (p2!=null){
        p1=p1?.next
        p2=p2.next?.next
    }
    var reversedList=reverse(p1)
    printLinkedList(reversedList)
    printLinkedList(head)
    var normalList=head
    while (reversedList!=null&&normalList!=null){
//        println("reverse list: "+reversedList.`val`)
//        println("normal list: "+normalList.`val`)
        if(reversedList.valu!=normalList.valu){
            return false
        }
        reversedList=reversedList.next
        normalList=normalList.next
    }
    return true
}
fun reverse(root:ListNode?): ListNode?{
    var curNode=root
    var prev:ListNode? = null
    while(curNode!=null){
        val next=curNode.next
        curNode.next=prev
        prev=curNode
        curNode=next
    }
    return prev
}
