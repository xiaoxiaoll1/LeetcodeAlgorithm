package sort;

import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        int arr[] = new int[]{-9,312,0,123,-142,43,-12,34,123};
        //quickSort(arr,0,arr.length-1);
        divide(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right){
        if(left>=right){
            return;
        }
        int l = left;
        int r = right;
        int base = arr[left];

        while (l!=r){
            while(base<=arr[r]&&l<r){
                r--;
            }
            while (base>=arr[l]&&l<r){
                l++;
            }
            if(l<r){
                int temp = arr[r];
                arr[r]=arr[l];
                arr[l]=temp;
            }
        }
        int temp = arr[r];
        arr[r]=base;
        arr[left]=temp;
        quickSort(arr,left,r-1);
        quickSort(arr,r+1,right);
    }

    public static void divide(int arr[],int left, int right){
        if(left>=right){
            return;
        }
        int mid = left+(right-left)/2;
        divide(arr,left,mid);
        divide(arr,mid+1,right);
        merge(arr,left,mid,right,new int[arr.length]);
    }

    public static void merge(int[]arr,int left, int mid ,int right ,int[] temp){

        int l = left;
        int m = mid+1;

        int t = left;
        while(l<=mid&&m<=right){
            if(arr[l]<arr[m]){
              temp[t]=arr[l];
              t++;
              l++;
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
        while (m<=right){
            temp[t]=arr[m];
            m++;
            t++;
        }
        for (int i = left; i <=right ; i++) {
            arr[i]=temp[i];
        }
    }
}
