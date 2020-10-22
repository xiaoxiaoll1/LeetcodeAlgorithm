package leetcode06;

public class SortList {
    public ListNode sortList(ListNode head) {

        if(head == null){
            return null;
        }
        ListNode middleNode = getMiddleNode(head);
        ListNode rightNode = middleNode.next;
        //这一步及其关键，保证了右边界
        middleNode.next=null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightNode);
        return mergeList(left,right);
    }


    public ListNode getMiddleNode(ListNode node){
        if(node==null||node.next==null){
            return node;
        }
        ListNode slow =node;
        ListNode fast = node.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeList(ListNode left, ListNode right){
        ListNode l = left;
        ListNode r = right;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l!=null&&r!=null){
            if(l.val<r.val){
                curr.next = l;
                l=l.next;
            }else {
                curr.next=r;
                r=r.next;
            }
            curr = curr.next;
        }
        if(l!=null){
            curr.next=l;
        }if(r!=null){
            curr.next = r;
        }
        return dummy.next;
    }
}
