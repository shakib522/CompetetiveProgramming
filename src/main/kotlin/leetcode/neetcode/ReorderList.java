package src.main.kotlin.leetcode.neetcode;

import java.util.Stack;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head==null || head.next==null){
            return;
        }
        ListNode cur=head;
        int size=1;
        Stack<ListNode> st=new Stack<>();
        while (cur!=null){
            size++;
            st.push(cur);
            cur=cur.next;
        }
        cur=head;
        int cnt=1;
        while (cnt<size/2){

                ListNode node=st.pop();
                ListNode temp=cur.next;
                cur.next=node;
                cur=temp;
                node.next=temp;
            cnt++;
        }
        cur.next=null;
    }
}
