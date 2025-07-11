class Solution {
    public int countDays(int days, int[][] meetings) {
        int[] day = new int[days+1];
        int count = 0;
        for(int i=0;i<meetings.length;i++){
            for(int j=meetings[i][0];j<=meetings[i][1];j++){
                if(day[j]!=1){
                    count++;
                    day[j]=1;
                }
            }
        }
        return days-count;
    }
}

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int l = 1, r = 0;
        for (int[] m : meetings) {
            if (m[0] > r) {
                days -= (r - l + 1);
                l = m[0];
            }
            r = Math.max(r, m[1]);
        }
        days -= (r - l + 1);
        return days;
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/count-days-without-meetings/solutions/3713170/wu-xu-kai-hui-de-gong-zuo-ri-by-leetcode-6c3i/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。