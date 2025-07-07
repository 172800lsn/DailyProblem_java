class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        //对nums数组按递增顺序排序，用array，sort方法
        Arrays.sort(nums);
        int[][] count = new int[n][2];
        for(int i= 0; i < n; i++){
            count[i][0] = 1;
            count[i][1] = 0;
            for(int j = i+1; j < n; j++){
                if(nums[j] - nums[i] == 1){
                    count[i][1] = 1;
                    count[i][0]++;
                }
                if(nums[j] - nums[i] == 0){
                    count[i][0]++;
                }
            }
        }
        Arrays.sort(count, (a,b) -> b[0] - a[0]);
        int res = 0;
        for(int i = 0; i < n; i++){
            if(count[i][1] != 0){
                res = count[i][0];
                break;
            }
        }
        return res;
    }
}