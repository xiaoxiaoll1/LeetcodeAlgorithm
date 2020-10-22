public class ACM {

    public int getNth(int n){
        if(n<1||n>50){
            System.out.println("impossible");
            throw new RuntimeException("impossible");
        }
        int[] nums = new int[50];
        nums[0] = 1;
        nums[1] = 1;
        if(n==1||n==2){
            return 1;
        }

        for (int i = 2; i < n; i++) {
            nums[i] = nums[i-1]+nums[i-2];
        }
        return nums[n-1];
    }
}
