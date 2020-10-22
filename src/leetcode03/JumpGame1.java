package leetcode03;

public class JumpGame1 {
    public boolean canJump(int[] nums) {

        int length = nums.length;
        int maxPosition = 0;

        for (int i = 0; i < length-1; i++) {
            if(nums[i]==0&&maxPosition<=i){
                return false;
            }
            maxPosition = Math.max(maxPosition,i+nums[i]);
            //贪心算法,这里如何理解？如果此时索引走到了之前的最远位置，那一定已经走了一步，但绝不会超过两步
            if(maxPosition>length){
                return true;
            }
        }
        return false;
}
}
