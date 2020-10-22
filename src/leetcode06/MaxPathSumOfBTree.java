package leetcode06;

public class MaxPathSumOfBTree {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;
        maxPathSumHelper(root);
        return maxSum;
    }

    //能对最大值贡献多少，不要负数
    public int maxPathSumHelper(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftMax = Math.max(0,maxPathSumHelper(node.left));
        int rightMax = Math.max(0,maxPathSumHelper(node.right));
        int curVal = node.val+leftMax+rightMax;
        maxSum=Math.max(curVal,maxSum);
        return node.val+Math.max(leftMax,rightMax);
    }
}
