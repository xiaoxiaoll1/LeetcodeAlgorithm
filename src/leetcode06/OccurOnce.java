package leetcode06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class OccurOnce {

    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        Object[] res = set.toArray();
        return (int) res[0];
    }

//异或操作满足交换律以及结合律，因此不用排序，同一个数的异或值为零
public int singleNumberByXOR(int[] nums) {
    int single = 0;
    for (int num : nums) {
        single ^= num;
    }
    return single;
}


}
