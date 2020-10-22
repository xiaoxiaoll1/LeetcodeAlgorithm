package leetcode02;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = new ListNode();
        if(l1==null){
            return l2;
        }if(l2==null){
            return l1;
        }

        if(l1.val<l2.val){
            dummy.next=l1;

        }else {
            dummy.next=l2;
        }

        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                curr.next=l1;
                l1=l1.next;
                curr=curr.next;
            }else {
                curr.next=l2;
                l2 = l2.next;
                curr=curr.next;
            }
        }
        curr.next=(l1==null)? l2:l1;
        return dummy.next;
    }
}


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }