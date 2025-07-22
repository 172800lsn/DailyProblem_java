class Solution {
    public String makeFancyString(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int len = res.length();
            if(len>=2 && res.charAt(len-1)==c && res.charAt(len-2)==c){
                continue;
            }
            res += c;
        }
        return res;
    }
}