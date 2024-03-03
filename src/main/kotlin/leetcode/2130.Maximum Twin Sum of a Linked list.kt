package leetcode

import kotlin.math.max


fun pairSum(head: ListNode?): Int {
    var curNode=head
    var curNode2=head
    var curNode3=head
    var count=0
    while (curNode!=null){
        count++
        curNode=curNode.next
    }
    for (i in 0..<(count/2)){
        curNode2=curNode2?.next
    }
    var temp=curNode2
    temp=reversedList(temp)
    curNode2?.next=null
    var ans=0
    while (temp!=null && curNode3!=null){
        ans= max(ans,temp.valu+curNode3.valu)
        temp=temp.next
        curNode3=curNode3.next
    }
    return ans
}

fun reversedList(head:ListNode?):ListNode?{
    var currNode=head
    var prev:ListNode? = null

    while (currNode!=null){
        val temp=currNode.next
        currNode.next=prev
        prev=currNode
        currNode=temp
    }
    return prev
}