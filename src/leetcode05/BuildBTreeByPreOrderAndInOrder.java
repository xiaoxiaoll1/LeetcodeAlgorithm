package leetcode05;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;

public class BuildBTreeByPreOrderAndInOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildTreeHelper(preorder,map,0,preorder.length-1,0,preorder.length-1);
    }

    //奇怪的是inRight是无用的
    public TreeNode buildTreeHelper(int[] preorder,HashMap<Integer, Integer> map
    ,int preLeft,int preRight,int inLeft, int inRight){
        if(preLeft>preRight){
            return null;
        }
        Integer pIndex = map.get(preorder[preLeft]);
        TreeNode root = new TreeNode(preorder[preLeft]);
        int leftSubTreeSize = pIndex - inLeft;
        root.left = buildTreeHelper(preorder,map,preLeft+1,preLeft+leftSubTreeSize,
                inLeft,pIndex-1);
        root.right = buildTreeHelper(preorder,map,preLeft+leftSubTreeSize+1,preRight,
                pIndex+1,inRight);
        return root;
    }
}
