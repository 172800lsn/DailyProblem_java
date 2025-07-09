class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int [r+1][c+1];
        for(int i=0;i<=r;i++) Arrays.fill(dp[i],Integer.MAX_VALUE);
        dp[1][1] = grid[0][0];
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if(i==1 && j==1) continue;
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[r][c];
    }
}