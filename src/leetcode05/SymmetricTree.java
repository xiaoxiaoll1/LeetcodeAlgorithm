package leetcode05;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return symmetricHelper(root.left,root.right);
    }

    public boolean symmetricHelper(TreeNode left, TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left!=null&&right!=null&&left.val!=right.val){
            return false;
        }
        if((left==null&&right!=null)||(left!=null&&right==null))return false;
        if(left!=null&&right!=null&&(!symmetricHelper(left.left,right.right))){
            return false;
        }if(left!=null&&right!=null&&(!symmetricHelper(left.right,right.left))){
            return false;
        }
        return true;
    }
}
