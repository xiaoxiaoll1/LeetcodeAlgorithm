package leetcode03;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TotalSort {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> curList = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        permuteHelper(nums,curList,res,set);
        return res;
    }

    public void permuteHelper(int []nums, List<Integer> curList, List<List<Integer>> res, HashSet<Integer> set){
        if(curList.size()==nums.length){
            res.add(new LinkedList<>(curList));
            //res.add(curList);
        }
        else {
            for (int i = 0; i < nums.length ; i++) {
                if(!set.contains(nums[i])){
                    curList.add(nums[i]);
                    set.add(nums[i]);
                    int index = curList.size()-1;
                    permuteHelper(nums,curList,res,set);
                    set.remove(nums[i]);
                    curList.remove(index);
                }
            }
        }
    }
}
