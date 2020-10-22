package sort;

import java.util.Arrays;

public class DivideSort {

    public static void main(String[] args) {
        int arr[] = new int[]{-9,32,0,123,-142,43,-12,34};
        divideAndMerge(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void divideAndMerge(int []arr, int left, int right){
        //int mid = (left + right)/2;
        int mid = left +(right-left)/2;
        if(left<right){
            divideAndMerge(arr,left,mid);
            divideAndMerge(arr,mid+1,right);
            merge(arr,left,mid,right,new int[arr.length]);
        }


    }


    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        if(left>=right){
            return;
        }
        int t = left;
        int l = left;
        int m = mid+1;
        int r = right;
        while (l<=mid&&m<=r){
            if(arr[l]<arr[m]){
                temp[t]=arr[l];
                l++;
                t++;
            }else {
                temp[t]=arr[m];
                m++;
                t++;
            }
        }
        while(l<=mid){
            temp[t]=arr[l];
            t++;
            l++;
        }
        while(m<=r){
            temp[t]=arr[m];
            m++;
            t++;
        }
        for (int i = left; i <t ; i++) {
            arr[i]=temp[i];
        }
    }

}
