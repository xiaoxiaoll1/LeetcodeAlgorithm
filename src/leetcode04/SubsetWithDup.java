package leetcode04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean flag = true;
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> curr = new LinkedList<>();
        subsetHelper(res,curr,0,nums, flag);
        if(nums.length==0){
            return null;
        }
        if(nums.length==1){
            curr.add(nums[0]);
            res.add(curr);
            res.add(new LinkedList<>());
            return res;
        }
        return res;

    }

    public void subsetHelper(ArrayList<List<Integer>> res,LinkedList<Integer> curr,int index,int[] nums,boolean flag) {
        //注意创建新的list加入，否则传过去的引用指向的list的值会变
        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
        } else {
            subsetHelper(res, curr, index + 1, nums, false);

                if (flag || (index > 0 && nums[index] != nums[index - 1])) {
                    curr.add(nums[index]);
                    subsetHelper(res, curr, index + 1, nums, true);
                    curr.remove(curr.size() - 1);
                }

        }
    }
}

//更好的思路
class Solution {
    ArrayList<List<Integer>> res=new ArrayList<>();
    ArrayList<Integer> one_path=new ArrayList<>();//一个可能的子集
    int n;
    int [] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums=nums;
        n=nums.length;
        //先排序，这样相同的两个元素必相邻
        Arrays.sort(nums);
        backtarck(0);
        res.add(new ArrayList<Integer>());//补上一个空集
        return res;
    }
    private void backtarck(int i){//将要填入下标为i的元素，也就是说该层从nums[i]处的元素开始for循环
        if(i==n){
            return;
        }
        //再dfs地加子节点
        for(int j=i;j<n;j++){//做的是子集，子集是组合，所以是从当前元素开始遍历
            if(j>i&&nums[j]==nums[j-1]) continue;//同层重复，跳过
            one_path.add(nums[j]);
            res.add(new ArrayList<Integer>(one_path));
            backtarck(j+1);
            one_path.remove(one_path.size()-1);//撤销选择

        }
    }
}


