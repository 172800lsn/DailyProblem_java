class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod=(int) (1e9+7);
        long ans=0;
        long dp[]=new long[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++) {
            for(int j=Math.max(i-forget+1, 1);j<=i-delay;j++) {
                dp[i]+=dp[j];
            }
            dp[i]%=mod;
        }
        for(int i=n-forget+1;i<=n;i++) {
            ans+=dp[i];
        }
        return (int) (ans%mod);
    }
}