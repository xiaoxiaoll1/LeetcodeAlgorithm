package leetcode05;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangle {

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

    public int largestRectangleAreaImprovedWithSentinel(int[] heights) {

        //相当于加上两个dummy node
        if(heights==null||heights.length==0){
            return 0;
        }
        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] newHeights = new int[heights.length + 2];
        for (int i = 0; i <heights.length ; i++) {
            newHeights[i+1]=heights[i];
        }
        heights=newHeights;
        for (int i = 1; i < heights.length; i++) {
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

        return area;
    }
}
