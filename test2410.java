class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int left = 0;
        int res = 0;
        for(int i=0;i<players.length;i++){
            while(left<trainers.length){
                if(players[i]<=trainers[left]){
                    res++;
                    left++;
                    break;
                }else{
                    left++;
                }
            }
            if(left==trainers.length){
                break;
            }
        }
        return res;
    }
}