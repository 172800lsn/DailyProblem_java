class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<=n; i++) Arrays.fill(dp[i],Integer.MAX_VALUE);
        dp[1][1] = triangle.get(0).get(0);
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                if(i==1 && j==1) continue;
                dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle.get(i-1).get(j-1);
            }
        }
        //获取最后一行的最小值
        int ans = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            ans = Math.min(ans,dp[n][i]);
        }
        return ans;
    }
}