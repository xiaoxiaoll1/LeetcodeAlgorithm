package leetcode03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TotalSortDuplicatePermitted {

    public static void main(String[] args) {
//        int[] ints = {1, 1, 3};
//        System.out.println(permute(ints));
    }

    public List<List<Integer>> permute(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> curList = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        permuteHelper(nums,curList,res,used);
        return res;
    }

    public void permuteHelper(int []nums, List<Integer> curList, List<List<Integer>> res, boolean[] used){
        if(curList.size()==nums.length){
            res.add(new LinkedList<>(curList));

        }
        else {
            //设置这个值的目的仅仅是为了避免重复
            int preNum = nums[0]-1;
            for (int i = 0; i < nums.length ; i++) {

                if(nums[i]!=preNum&&used[i]==false){
                    preNum = nums[i];
                    curList.add(nums[i]);
                    used[i] = true;
                    int index = curList.size()-1;
                    permuteHelper(nums,curList,res,used);
                    used[i]=false;
                    curList.remove(index);
                }
            }
        }
    }
}
