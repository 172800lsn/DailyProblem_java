class Solution {
    public char kthCharacter(int k) {
        String res = "a";
        for(int i = 0;i < 9 ; i++) {
            if(k <= Math.pow(2,i)) {
                break;
            }
            //生成res中的字符对应的在字母表中的下一个字符，并加入到res中,注意z后面是a
            int len = res.length();
            for(int j = 0;j<len;j++) {
                res = res + (char)('a' + (res.charAt(j) - 'a' + 1) % 26);
            }
        }
        return res.charAt(k-1);
    }
}
class Solution {
    public char kthCharacter(int k) {
        int ans = 0;
        int t;
        while (k != 1) {
            t = 31 - Integer.numberOfLeadingZeros(k);
            if ((1 << t) == k) {
                t--;
            }
            k = k - (1 << t);
            ans++;
        }
        return (char) ('a' + ans);
    }
}
