package leetcode02;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
    }
    
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        parenthesisHelper("",n,0,0,list);
        return list;
    }
    
    
    
    public static void parenthesisHelper(String curr, int n, int left, int right, List<String> list){
        if(right==n){
            list.add(curr);
            return;
        }if(left<n){
           // curr+="(";
            parenthesisHelper(curr+"(",n,left+1,right,list);
        }if(right<left){
            //curr+=")";
            parenthesisHelper(curr+")",n,left,right+1,list);
            //一定注意，这两种写法完全不同，在递归中一定要用下面的写法，不然回溯不到原先的值！！！！！！！！！
        }
    }
}
