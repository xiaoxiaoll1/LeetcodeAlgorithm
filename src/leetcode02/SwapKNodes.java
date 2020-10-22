package leetcode02;

import java.util.Stack;

public class SwapKNodes {

    //逆序输出可以用栈来实现
    public ListNode reverseKGroupByStack(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode next = dummy.next;
        while (next!=null){
            for (int i = 0; i < k&&next!=null; i++) {
                stack.push(next);
                next=next.next;
            }
            if(stack.size()<k&&next==null){
                return dummy.next;
            }

            while (!stack.isEmpty()){
                ListNode pop = stack.pop();
                prev.next = pop;
                prev = prev.next;
            }
            prev.next = next;
        }
        return dummy.next;
    }

    //一个大的list的倒序分为多个小步骤
    public ListNode reverseKGroupBySwapSubList(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode real = dummy;
        while (prev!=null){
            prev = reverse(prev,k);
        }
        return dummy.next;

    }
    //链表的倒叙应该都可以按照这个方法
    public ListNode reverse(ListNode prev, int k){
        ListNode last = prev;
        for (int i = 0; i < k+1 ; i++) {
            last = last.next;
            if(last==null&&i<k){
                return null;
            }
        }
        ListNode tail = prev.next;
        ListNode curr = prev.next.next;
        while (curr!=last){
            ListNode next = curr.next;
            curr.next =prev.next;
            prev.next = curr;
            //这一步做完，头节点已经变了，即dummy.next拥有了正确的值
            tail.next = next;
            curr = next;
        }
        return tail;
    }
}
