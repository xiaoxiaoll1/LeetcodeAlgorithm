package leetcode03;

public class JumpGame2 {
    public int jump(int[] nums) {

        int length = nums.length;
        int maxPosition = 0;
        int end =0;
        int step = 0;
        for (int i = 0; i < length-1; i++) {
            maxPosition = Math.max(maxPosition,i+nums[i]);
            //贪心算法,这里如何理解？如果此时索引走到了之前的最远位置，那一定已经走了一步，但绝不会超过两步
            if(i==end){
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
