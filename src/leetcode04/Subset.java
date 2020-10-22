package leetcode04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subset {
    //画图，画出递归回溯的过程，循环是同一层的变化，递归是由上层到下层

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> curr = new LinkedList<>();
        subsetHelper(res,curr,0,nums);
        return res;

    }

    public void subsetHelper(ArrayList<List<Integer>> res,LinkedList<Integer> curr,int index,int[] nums){
        //注意创建新的list加入，否则传过去的引用指向的list的值会变
        res.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            subsetHelper(res,curr,i+1,nums);
            curr.remove(curr.size()-1);
        }
    }
}
