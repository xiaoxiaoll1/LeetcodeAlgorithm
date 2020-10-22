package leetcode05;

public class BinarySearch {

    public int binaryS(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;

        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]==target){
                return mid;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }
}
