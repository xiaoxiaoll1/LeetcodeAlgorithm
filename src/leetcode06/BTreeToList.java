package leetcode06;






import java.util.ArrayList;
import java.util.List;

public class BTreeToList {

    public void flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();

        flattenHelper(root,list);
        for (int i = 1; i <list.size() ; i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode curr = list.get(i);
            prev.left=null;
            prev.right=curr;
        }
        TreeNode last = list.get(list.size() - 1);
        last.left=null;
        last.right=null;

    }
    public void flattenHelper(TreeNode node, List<TreeNode> list){
        if(node==null){
            return;
        }
        list.add(node);
        flattenHelper(node.left,list);
        flattenHelper(node.right,list);
    }

}
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }