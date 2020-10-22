package leetcode06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        String s = "catsanddog";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        wordBreak(s,wordDict);
    }
    public static List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>(wordDict);
        List<String> list = wordBreakHelper(s, 0, set);
        return list;

    }

    public static List<String> wordBreakHelper(String s,int start,HashSet<String> set){
        //因为每一层递归都创建了一个list，所以一旦失败，返回的仍是空list
        LinkedList<String> list = new LinkedList<>();
        if(start==s.length()){
            list.add("");
        }
        for (int i = start+1; i <= s.length(); i++) {
            if (set.contains(s.substring(start, i))) {

                List<String> curList = wordBreakHelper(s, i, set);

                for (String curs:curList
                ) {
                    if(curs==null){
                        continue;
                    }
                    else if(curs.equals("")){
                        list.add(s.substring(start,i));
                    }else {
                        list.add(s.substring(start,i)+" "+curs);
                    }
                }

            }
        }
        return list;
    }
}
