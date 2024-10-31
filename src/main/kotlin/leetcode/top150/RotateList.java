package src.main.kotlin.leetcode.top150;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null){
            return head;
        }
        int cnt=1;
        ListNode temp=head;
        while (temp.next!=null){
            cnt++;
            temp=temp.next;
        }
        k=k%cnt;
        int rotate=cnt-k;
        temp.next=head;
        for (int i=0;i<rotate;i++){
            head=head.next;
        }
        ListNode newNode=head.next;
        head.next=null;
        return newNode;
    }
}
