class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events,(a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int[] starts = new int[n];
        for(int i = 0; i < n; i++) starts[i] = events[i][0];

        int[] next = new int[n];
        for(int i = 0; i < n; i++){
            int lo = i+1, hi = n;
            while(lo < hi){
                int mid = (lo+hi)/2;
                if(starts[mid] > events[i][1]) hi = mid;
                else lo = mid + 1;
            }
            next[i] = lo;
        }
        long[][] dp = new long[n+1][k+1];
        for(int i = n-1; i >= 0; i--){
            for(int j = 1;j <= k;j++){
                long skip = dp[i+1][j];
                long take = events[i][2] + dp[next[i]][j-1];
                dp[i][j] = Math.max(take, skip);
            }
        }
        return (int)dp[0][k];
    }
}