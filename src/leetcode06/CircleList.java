package leetcode06;


import java.util.HashSet;

public class CircleList {
    public boolean hasCycle(ListNode head) {

        if(head==null)return false;

        HashSet<ListNode> set = new HashSet<>();
        while (head.next!=null){
            if(set.contains(head.next)){
                return true;
            }else {
                set.add(head.next);
            }
            head=head.next;
        }

    return false;
    }
}




class ListNode {
    int val;
     ListNode next;
      ListNode(int x) {
     val = x;
         next = null;
     }
  }