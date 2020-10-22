package leetcode02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
        letterCombinations("234");
    }

    static ArrayList<String> list = new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        if(digits.equals("")||digits==null){
            return list;
        }
        dfs(digits,map,0,"");
        return list;


    }
    public static void dfs(String digits, Map<Character,String> map,int index,String curr){
        if(index>=digits.length()){
            list.add(curr);
            return;
        }else {
            char c = digits.charAt(index);
            String s = map.get(c);
            index=index+1;
            for (char ch:s.toCharArray()
                 ) {
                String newCurr=curr+ch;
                dfs(digits,map,index,newCurr);
                //这里递归出来后仍在循环内，而String这个引用对应的值已经改变了
            }
        }
    }
}
