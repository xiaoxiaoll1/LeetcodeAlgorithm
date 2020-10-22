package leetcode03;

public class NextSortedArray {
    public void nextPermutation(int[] nums) {

        int last = nums.length-1;
        int index = last;
        if(nums.length==0||nums==null){
            return;
        }
        while(index>0){
            if(nums[index-1]<nums[index]){
                int min = findMin(nums, index - 1);
                swap(nums,index-1,min);
                reverse(nums,index);
                return;
            }
            index--;
        }
        reverse(nums,0);


    }
    //数组通用倒转和交换方法
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int findMin(int []nums, int index){
        int i=nums.length-1;
        while(i>index){
            if(nums[i]>nums[index]){
                return i;
            }
            i--;
        }
        return i;
    }
}


