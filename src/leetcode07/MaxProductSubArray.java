package leetcode07;

public class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        dpMax[0] = nums[0];
        int[] dpMin = new int[nums.length];
        dpMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>0){
                dpMax[i] = Math.max(dpMax[i-1]*nums[i],nums[i]);
                dpMin[i] = Math.min(dpMin[i-1]*nums[i],nums[i]);
            }else {
                dpMax[i] = Math.max(dpMin[i-1]*nums[i],nums[i]);
                dpMin[i] = Math.min(dpMax[i-1]*nums[i],nums[i]);
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            ans = Math.max(ans,dpMax[i]);
        }
    return ans;
    }
}
