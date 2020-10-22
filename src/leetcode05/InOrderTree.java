package leetcode05;

import java.util.ArrayList;
import java.util.List;

public class InOrderTree {
    public List<Integer> inorderTraversal(TreeNode root) {


        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;

    }


    public void inOrder(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);

    }
    public void preOrder(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        list.add(node.val);
        preOrder(node.left,list);
        preOrder(node.right,list);
    }
    public void postOrder(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        postOrder(node.left,list);
        postOrder(node.right,list);
        list.add(node.val);
    }
}














class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}