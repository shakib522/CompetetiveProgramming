package leetcode


fun oddEvenList(head: ListNode?): ListNode? {
    val evenHead=head?.next
    var temp: ListNode? = head
    var temp2: ListNode? = head?.next

    while (temp2!=null && temp2.next != null) {
        temp?.next=temp?.next?.next
        temp2.next =temp2.next?.next
        temp=temp?.next
        temp2= temp2.next
    }
    temp?.next=evenHead
    return head
}
