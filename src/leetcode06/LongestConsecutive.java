package leetcode06;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxLength=0;
        for (int i:nums
             ) {
            set.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i]-1)){
                int curLength=1;
                int target = nums[i];
                while (true){
                    if(set.contains(target+1)){
                        curLength+=1;
                        target+=1;
                    }else {
                        maxLength = Math.max(maxLength,curLength);
                        break;
                    }
                }
            }
        }
        return maxLength;

    }


}
