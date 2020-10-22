package leetcode04;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length()+1;
        int n = word2.length()+1;

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        int[][] dp = new int[m][n];
        for (int i = 0; i <m ; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i]=i;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(chars1[i-1]==chars2[j-1]){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]);
                }else {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]+1);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
