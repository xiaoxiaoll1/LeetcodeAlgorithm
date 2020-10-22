package leetcode04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
       subsets(new int[]{1,2,3});
    }

    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> curr = new LinkedList<>();
        subsetHelper(res,curr,0,nums);
        return res;

    }

    public static void subsetHelper(ArrayList<List<Integer>> res,LinkedList<Integer> curr,int index,int[] nums){
        res.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[index]);
            subsetHelper(res,curr,index+1,nums);
            curr.remove(curr.size()-1);
        }
    }
}
