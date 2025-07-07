class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int length = 60;

        for(int i=0;i<nums.length;i++){
            int result = nums[i];
            for(int j=i;j<nums.length;j++){
                result = result|nums[j];
                if(result>=k && j-i+1<length){
                    length = j-i+1;
                }
            }
        }

        return length == 60?-1:length;
    }
}