class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r+2][c+2];
        for(int i=0; i<r+2; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if(i==1){
                    dp[i][j] = matrix[i-1][j-1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1])) + matrix[i-1][j-1];
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0;i<=c;i++){
            res = Math.min(res, dp[r][i]);
        }
        return res;
    }
}