package leetcode02;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKIncrementList {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0||lists==null){
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.length, (v1, v2) -> {
            if(v1.val<v2.val){
                return -1;
            }else if(v1.val==v2.val)return 0;
            else return 1;
        });
        ListNode dummy = new ListNode(0);
        ListNode curr=dummy;
        for (ListNode node:lists
             ) {
            if(node!=null) priorityQueue.add(node);
        }
        //dummy.next=priorityQueue.peek();
        while (!priorityQueue.isEmpty()){
            curr.next = priorityQueue.poll();
            //这里十分关键，这里的curr仍然等于dummy，相当于dummy.next= priorityQueue.poll();
            curr = curr.next;
            //但是这里curr与dummy断开了联系
            if(curr.next!=null)priorityQueue.add(curr.next);
            //这是最关键的一步，每次poll出来节点，就由该节点的下一个节点进入queue参与比较
        }
        return dummy.next;
    }

    public ListNode mergeKListsByDivideAndConquer(ListNode[] lists) {
        if(lists.length==0||lists==null){
            return null;
        }
        int right = lists.length-1;
        int left = 0;
        ListNode merge = merge(lists, left, right);
        return merge;
    }

    public ListNode merge(ListNode[] lists,int left, int right){
        if(left>=right){
            return lists[left];
        }
        int mid = (left+right)/2;
        ListNode l1 = merge(lists,left,mid);
        ListNode l2 = merge(lists,mid+1,right);
        //如何推导以上两式？可有返回值里面的参数来确定
        return mergeTwoLists(l1,l2);
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            //递归的心得：1.要思考下一步到底要返回什么
            //2.递归是先进后出，因此要想好最后一步的情况是什么
            //3.考虑整个递归结束时第一次递归的返回值
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

}

