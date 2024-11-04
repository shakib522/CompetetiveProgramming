package src.main.kotlin.leetcode.top150;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur=head;
        int cnt=0;
        while (cur!=null){
            cnt++;
            cur=cur.next;
        }
        if (cnt==1){
            head=head.next;
            return head;
        }
        int range=cnt-n;
        cur=head;
        if(range==0){
            head=head.next;
            return head;
        }
        for (int i = 0; i < range-1; i++) {
            cur=cur.next;
        }
        if (range==cnt-1) {
            cur.next = null;
        }else{
            cur.next=cur.next.next;
        }
        return head;
    }
}
