class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] arr = new int[10001];
        for(int i = 0;i<nums.length;i++){
            arr[nums[i]] += nums[i];
        }
        int[] dp = new int[10002];
        dp[1] = arr[0];
        for(int i = 1;i<10001;i++){
            dp[i+1] = Math.max(dp[i],dp[i-1]+arr[i]);
        }
        return dp[10001];
    }
}