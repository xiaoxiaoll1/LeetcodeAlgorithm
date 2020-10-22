package leetcode03;

public class SortedArrayStartAndEnd {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
//        int startPoint = 0;
//        int endPoint = nums.length-1;
        int[] res={-1,-1};
        while (left+1<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>=target){
                right = mid;
            }else left=mid;
        }
        if(nums[left]==target){
            res[0]=left;
        }else if(nums[right]==target){
            res[0]=right;
        }else {
            return res;
        }
        right= nums.length-1;
        while (left+1<right){
            int mid = left+(right-left)/2;
            if(nums[mid]<=target){
                left = mid;
            }else right=mid;
        }
        if(nums[right]==target){
            res[1]=right;
        }else if(nums[left]==target){
            res[1]=left;
        }
        return res;
    }
}
