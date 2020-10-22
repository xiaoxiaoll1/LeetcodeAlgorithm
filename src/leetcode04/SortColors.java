package leetcode04;

public class SortColors {

    public void sortColors(int[] nums) {

        if(nums==null||nums.length==0||nums.length==1){
            return;
        }

        int first = 0;
        int last = nums.length-1;
        int index=0;
        while (nums[first]==0){
            first++;
            index++;

        }
        if(nums[index]==2){
            int temp = nums[last];
            nums[last]=2;
            nums[index] = temp;
            last--;
        }
        index=index+1;
        while (index<last){

            if(nums[index]==2){
                int temp = nums[last];
                nums[last]=2;
                nums[index] = temp;
                last--;
            }
            if(nums[index]==0){
                int temp = nums[first];
                nums[first] = 0;
                nums[index] = temp;
                first++;
                index++;
            }
            else{
                index++;
            }
        }
    }
}
