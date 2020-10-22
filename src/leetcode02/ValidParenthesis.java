package leetcode02;

import java.util.Stack;

public class ValidParenthesis {
    //对于这种有多少可能性的问题，很多都是递归回溯问题，深度优先常伴随回溯
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        //char curr;
        if(s.equals("")||s==null){
            return true;
        }
        if(s.charAt(0)==')'||s.charAt(0)==']'||s.charAt(0)=='}'){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){

                stack.push(s.charAt(i));
            }
            if(s.charAt(i)==')'||s.charAt(i)==']'||s.charAt(i)=='}'){
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if(pop=='('&&s.charAt(i)!=')'){
                    return false;
                }
                if(pop=='['&&s.charAt(i)!=']'){
                    return false;
                }
                if(pop=='{'&&s.charAt(i)!='}'){
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
