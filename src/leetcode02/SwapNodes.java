package leetcode02;

public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode curr = dummy;
        while(curr.next!=null&&curr.next.next!=null){
            ListNode l1 = curr.next;
            ListNode l2 = curr.next.next;
            l1.next = l2.next;
            l2.next = l1;
            curr.next = l2;
            curr = l1;
        }
        return dummy.next;
    }
}
