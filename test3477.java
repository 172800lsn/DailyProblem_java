class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ans = fruits.length;
        for(int fruit:fruits){
            for(int i=0;i<baskets.length;i++){
                if(baskets[i]>=fruit){
                    baskets[i] = 0;
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}
