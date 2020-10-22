package leetcode06;

import java.util.HashMap;
import java.util.HashSet;

public class CircleListTwo {
    public ListNode detectCycle(ListNode head) {

        if(head==null)return null;

        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            if(set.contains(head)){
                return head;
            }else {
                set.add(head);
            }
            head=head.next;
        }

        return null;
    }
}
