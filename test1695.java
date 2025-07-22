class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Set<Integer> seen = new HashSet<>();
        int ans = 0, psum = 0;
        for (int i = 0, j = 0; i < n; ++i) {
            psum += nums[i];
            while (seen.contains(nums[i])) {
                seen.remove(nums[j]);
                psum -= nums[j];
                j++;
            }
            seen.add(nums[i]);
            ans = Math.max(ans, psum);
        }
        return ans;
    }
}
