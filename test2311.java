class Solution {
public int longestSubsequence(String s, int k) {
    int n = s.length();
    int count = 0;
    int num = 0;

    for (char c : s.toCharArray()) {
        if (c == '0') {
            count++;
        }
    }

    for (int i = n - 1; i >= 0; i--) {
        if (s.charAt(i) == '1') {
            int len = n - 1 - i;
            if (len < 31 && (num | (1 << len)) <= k) {
                num |= (1 << len);
                count++;
            }
        }
    }
    return count;
}
}