package leetcode02;

public class SearchRotateSortedArray {
    //二分法就是不断缩小范围，这种特别的数组不好理解的话就画图，分情况讨论看怎么才能让left和right夹得更紧。

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        search(nums,target);
    }
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        if(nums==null||nums.length==0){
            return -1;
        }
        while (left+1<right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            if(nums[mid]>nums[left]){
                if (target <= nums[mid]&&target>=nums[left])
                    right = mid;
                else left = mid;
            }
            if(nums[mid]<nums[right]){
                if(target>=nums[mid]&&target<=nums[right]){
                    left=mid;
                }else right=mid;
            }
            //错误理解
//            if (target > nums[left]) {
//                if (target < nums[mid])
//                    right = mid;
//                else left = mid;
//            }
//            else if(target<nums[right]){
//                if(target>nums[mid]){
//                    left=mid;
//                }else right=mid;
//        }
        }
        if(nums[left]==target)return left;
        if(nums[right]==target)return right;
        return -1;
    }
}
