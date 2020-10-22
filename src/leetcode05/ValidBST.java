package leetcode05;

public class ValidBST {

    private static boolean ifValid=true;
    public boolean isValidBST(TreeNode root) {
        isValidBSTHelper(root);
        if(ifValid){
            return true;
        }else {
            return false;
        }

    }

    public void isValidBSTHelper(TreeNode node){
        if(node==null){
            return ;
        }
        else {
            if(node.left!=null&&node.val<=node.left.val){
                ifValid=false;
                return ;
            }
            if(node.right!=null&&node.val>=node.right.val){
                ifValid=false;
                return ;
            }
            isValidBSTHelper(node.left);
            if(ifValid==false)return;
            isValidBSTHelper(node.right);
        }
    }


    //这里只要有一个是false，那么返回的一定是false
    public boolean helper(TreeNode node, Integer lower, Integer upper) {

        if(node==null){
            return true;
        }
        int val = node.val;
        if(lower!=null&&val<=lower)return false;
        if(upper!=null&&val>=upper)return false;
        if(!helper(node.left,lower,val)) return false;
        if(!helper(node.right,val,upper))return false;

        return true;

    }

    public boolean isValidBSTImproved(TreeNode root) {
        return helper(root,null,null);
    }


}
