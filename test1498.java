class Solution {
    static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        // 预计算 2^k mod MOD
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int k = 1; k < n; k++) {
            pow2[k] = (pow2[k - 1] << 1) % MOD;   // (2 * pow2[k-1]) % MOD
        }

        long ans = 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                // 以 nums[l] 为最小值，右端可取到 r，区间长度 (r-l)
                ans += pow2[r - l];
                if (ans >= MOD) ans -= MOD;
                l++;           // 换更大的最小值
            } else {
                r--;           // 最大值太大，缩小 r
            }
        }
        return (int) ans;
    }
}
