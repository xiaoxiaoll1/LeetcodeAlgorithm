package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = new int[]{-9,32,0,123,-142,43,-12,34};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right){
        if(left>=right){
            return;
        }
        int base = arr[left];
        int l = left;
        int r = right;
        while (l!=r){
            int temp = 0;

            while (arr[r]>=base&&l<r){
                r--;
            }
            while (arr[l]<=base&&l<r){
                l++;
            }
            if(l<r){
                temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }

        }

        arr[left] = arr[l];
        arr[l]=base;
        quickSort(arr,left,l-1);
        quickSort(arr,l+1,right);
    }


    public static void quickSort3(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
                j=high;
                //temp就是基准位
                temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减

            while (temp<=arr[j]&&i<j) {
                j--;
            }

            //再看左边，依次往右递增

            while (temp>=arr[i]&&i<j) {
                i++;
            }

            //如果满足条件则交换
            if (i<j) {
                int z = arr[i];
                int y = arr[j];

                arr[i] = y;
                arr[j] = z;
            }

        }


        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;

        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }
}
