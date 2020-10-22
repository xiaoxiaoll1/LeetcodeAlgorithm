package leetcode06;

import java.util.HashSet;
import java.util.List;

public class WordBreakOne {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0]=true;
        for (int i = 1; i <=s.length() ; i++) {

            for (int j = i; j >=0 ; j--) {
                String ss = s.substring(j,i);
                if(set.contains(ss)){
                    if(dp[j]==true){
                        dp[i]=true;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
