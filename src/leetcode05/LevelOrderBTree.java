package leetcode05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderBTree {
    public List<List<Integer>> levelOrderByDFS(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        levelOrder(root,res,1);
        return res;


    }

    public void levelOrder(TreeNode node,LinkedList<List<Integer>> res,int floor){
            if(node==null){
                return;
            }
        if(res.size()<floor){
            List<Integer> list = new ArrayList<Integer>();
            res.addLast(list);
        }
        List<Integer> list  = res.get(floor-1);


                list.add(node.val);
                levelOrder(node.left,res,floor+1);
                levelOrder(node.right,res,floor+1);


    }

    public List<List<Integer>> levelOrderByBFS(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while(queue.size()>0) {
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            //如果节点的左/右子树不为空，也放入队列中
            for(int i=0;i<size;++i) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if(t.left!=null) {
                    queue.add(t.left);
                }
                if(t.right!=null) {
                    queue.add(t.right);
                }
            }
            //将临时list加入最终返回结果中
            res.add(tmp);
        }
        return res;
    }

}
