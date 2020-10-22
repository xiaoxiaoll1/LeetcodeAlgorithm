package leetcode02;

public class RemoveLastNNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0){
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode fast = dummy;
        ListNode targetHead;
        for (int i = 1; i <=n+1 ; i++) {
            fast=fast.next;
        }
        while (fast.next!=null&&fast!=null){
            dummy=dummy.next;
            fast=fast.next;
        }
        if(dummy==head){
            targetHead = head.next;
            return targetHead;
        }else {
            dummy.next=dummy.next.next;
            return head;
        }

    }
}


//class ListNode2 {
//    int val;
//    ListNode2 next;
//
//    ListNode2(int x) {
//        val = x;
//    }
//}
