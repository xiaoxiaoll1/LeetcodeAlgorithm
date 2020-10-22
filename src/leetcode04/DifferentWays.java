package leetcode04;

public class DifferentWays {
    public int uniquePaths(int m, int n) {
        if(m==0||n==0){
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            if(m==0){
                return 1;
            }
            int n = obstacleGrid[0].length;
            if(m==1){
                for (int i = 0; i <n ; i++) {
                    if(obstacleGrid[0][i]==1){
                        return 0 ;
                    }

                }
                return 1;
            }
            if(obstacleGrid[0][0]==1){
                return 0;
            }
            for (int i = 0; i < m; i++) {
                if(obstacleGrid[i][0]==1){
                    obstacleGrid[i][0]=0;
                    for (int j = i; j < m; j++) {
                        obstacleGrid[j][0]=0;

                    }
                    break;
                }
                obstacleGrid[i][0]=1;
            }
            for (int i = 1; i < n; i++) {
                if(obstacleGrid[0][i]==1){
                    obstacleGrid[0][i]=0;
                    for (int j = i; j < n; j++) {
                        obstacleGrid[0][j]=0;

                    }
                    break;
                }
                obstacleGrid[0][i]=1;
            }
            for (int i = 1; i <m ; i++) {
                for (int j = 1; j < n; j++) {
                    if(obstacleGrid[i][j]==1){
                        obstacleGrid[i][j]=0;
                        continue;
                    }

                    obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }
            }
            return obstacleGrid[m-1][n-1];
        }
    }

}
