class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();  // key: 数值, value: 下标
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                // 找到了满足条件的两个数
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);  // 先放进去当前值及其下标
        }
        return new int[0]; // 题目保证有解，这一行理论上不会被执行
    }
}
