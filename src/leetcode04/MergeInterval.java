package leetcode04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {

        int length = intervals.length;
        int count = 0;
        int[] begin = new int[length];
        int[] end = new int[length];

        if(length==1){
            return intervals;
        }

        for (int i = 0; i < length; i++) {
            begin[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i <length-1; i++) {
            if(end[i]<begin[i+1]){
             int[] curr= new int[]{begin[i],end[i]};
             list.add(curr);
                if(i==length-2){
                    int[] curr2= new int[]{begin[i+1],end[i+1]};
                    list.add(curr2);
                }
            }else {
                if(i==length-2){
                    int[] curr= new int[]{begin[i],end[i+1]};
                    list.add(curr);
                    break;
                }
                begin[i+1]=begin[i];

            }


        }
        int[][] results = new int[list.size()][2];
        for (int i = 0; i <list.size() ; i++) {
            results[i]=list.get(i);
        }
        return results;
        //int[][] results = new int[length][2];
    }
}
