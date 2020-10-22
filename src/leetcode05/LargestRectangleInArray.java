package leetcode05;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class LargestRectangleInArray {
    public int maximalRectangle(char[][] matrix) {

        if(matrix.length==0) return 0;
        int area=0;
        int[] height = new int[matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {

            for (int j = 0; j < matrix.length; j++) {
                if(matrix[j][i]=='0'){
                    height[j]=0;
                }else if(matrix[j][i]=='1'){
                    height[j]+=1;
                }
            }
            int i1 = largestRectangleArea(height);
            area = Math.max(area,i1);
        }
        return area;
    }
    



    public int largestRectangleArea(int[] heights) {

        if(heights==null||heights.length==0){
            return 0;
        }
        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty()&&heights[stack.peekLast()]>heights[i]){
                int height = heights[stack.removeLast()];
                int width;
                if(stack.isEmpty()){
                    width=i;
                }else {
                    width = i - stack.peekLast() -1;
                }
                area = Math.max(area,height*width);
            }
            stack.addLast(i);
        }
        while (!stack.isEmpty()){
            int height = heights[stack.removeLast()];
            int width;
            if(stack.isEmpty()){
                width=heights.length;
            }else {
                width = heights.length - stack.peekLast() -1;
            }
            area = Math.max(area,height*width);
        }
        return area;
    }

}
