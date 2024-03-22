package src.main.kotlin.leetcode.q75

import kotlin.math.max

fun main(){

}
fun appending(head: ListNode?, item: Int): ListNode {
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
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var first= l1
    var second= l2
    var ans : ListNode? = null
    var mod=0
    for (i in 0..<max(cnt(l1),cnt(l2))){
       var fNum=0
        var sNum=0
        if (first != null){
            fNum= first.valu
        }
        if (second!=null){
            sNum=second.valu
        }
        val total=fNum+sNum+mod
        ans= appending(ans, total % 10)
        mod=total/10
        first=first?.next
        second=second?.next
    }
    if (mod>0){
        ans= appending(ans, mod)
    }
    return ans
}
fun cnt(head:ListNode?):Int{
    var len=0
    var currNode=head
    while (currNode!=null){
        len++
        currNode=currNode.next
    }
    return len
}
fun reversing(node:ListNode?):ListNode?{
    var prev:ListNode ? = null
    var len=0
    var nodeList=node
    //at first, we need to reverse the list
    while (nodeList!=null){
        len++
        val temp=nodeList.next
        nodeList.next=prev
        prev=nodeList
        nodeList=temp
    }

    return prev
}