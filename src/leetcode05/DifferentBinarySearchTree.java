package leetcode05;

public class DifferentBinarySearchTree {
    public int numTrees(int n) {
        int[] nums = new int[n+1];
        nums[0]=1;
        nums[1]=1;
//        n=n-1;
        for (int i = 2; i <= n; i++) {
            nums[i] = arraySum(nums, i);
        }
        return nums[n];
    }


    public int arraySum(int[] nums,int index){
        int sum=0;
        for (int i = 0; i < index; i++) {
            sum+=nums[i]*nums[index-i-1];
        }
        return sum;
    }
}
