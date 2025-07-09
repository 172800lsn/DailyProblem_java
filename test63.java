class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        int[][] dp = new int[r+1][c+1];
        dp[1][1] = 1;
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if(obstacleGrid[i-1][j-1]==1) dp[i][j] = 0;
                else dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[r][c];
    }
}