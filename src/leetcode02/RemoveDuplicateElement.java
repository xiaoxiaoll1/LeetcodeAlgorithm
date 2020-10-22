package leetcode02;

public class RemoveDuplicateElement {

    public int removeElement(int[] nums, int val) {
        int first = 0;
        int slow = 0;
        int length = nums.length-1;

        while (first<=length){
            if(nums[first]!=val){
                nums[slow]=nums[first];
                first++;
                slow++;
            }else {
                first++;

            }
        }
        return slow;
    }
}
