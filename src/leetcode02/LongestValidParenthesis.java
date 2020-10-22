package leetcode02;

import java.util.Stack;

public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {

        if(s==null||s.length()<2){
            return 0;
        }
        int leftmost=-1;
        int maxLength = 0;
        //不要设置泛型为Character的栈，因为push的不是括号
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.push(i);
                //这里千万不要把‘（’这种东西push进去了，因为没有任何意义。这里将数组索引push就不用再另行记录了
            }else if(s.charAt(i)==')') {
                if (stack.isEmpty()) {
                    leftmost = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxLength = Math.max(maxLength, i - leftmost);
                    } else {
                        Integer top = stack.peek();
                        maxLength = Math.max(maxLength, i - top);
                    }
                }
            }
        }
        return maxLength;
    }
}
