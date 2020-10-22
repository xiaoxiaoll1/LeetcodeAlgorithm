package leetcode05;

public class MaxDepthOfBTree {

    public int maxDepth(TreeNode root) {

        return maxDepthHelper(root);

    }
    //每递归一层，高度加一，递归核心，返回值是什么，参数是什么
    public int maxDepthHelper(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftHeight = maxDepthHelper(node.left);
        int rightHeight = maxDepthHelper(node.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
}
