package leetcode03;

public class MaxSumOfSubSequence {
    public int maxSubArrayGreedy(int[] nums) {
        int length = nums.length;
        if(length==0||nums==null){
            return 0;
        }
        int maxSum = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < length-1; i++) {
            currSum = Math.max(currSum+nums[i],nums[i]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }

    public int maxSubArrayDynamic(int[] nums){
        int length = nums.length;
        if(length==0||nums==null){
            return 0;
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        int maxSum=dp[0];
        for (int i = 1; i < length; i++) {
            if(dp[i-1]<0){
                dp[i]=nums[i];
            }else {
                dp[i]=dp[i-1]+nums[i];
            }
            maxSum=Math.max(maxSum,dp[i]);
        }
        return maxSum;
    }
}
