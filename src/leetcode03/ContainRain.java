package leetcode03;

import java.util.Stack;

public class ContainRain {
    public int trap(int[] height) {
        if(height.length==0||height==null){
            return 0;
        }
        int length = height.length;
        int[] left = leftMost(height, length);
        int[] right = rightMost(height, length);
        int container=0;
        for (int i = 0; i <length ; i++) {
            int curHeight = Math.min(left[i],right[i])-height[i];
            if(curHeight>0){
                container+=curHeight;
            }
        }
        return container;
    }
    
    public int[] leftMost(int[] height, int length){
        int[] left = new int[length];
        left[0]=0;
        int leftmost = 0;
        for (int i = 0; i < height.length-1; i++) {
            leftmost = Math.max(leftmost,height[i]);{
                left[i+1]=leftmost;
            }
        }
        return left;
    }
    public int[] rightMost(int[] height, int length){
        int[] right = new int[length];
        right[length-1]=0;
        int rightmost = 0;
        for (int i = length-1; i >0; i--) {
            rightmost = Math.max(rightmost,height[i]);{
                right[i-1]=rightmost;
            }
        }
        return right;
    }


    public int trapWithStack(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }

}
