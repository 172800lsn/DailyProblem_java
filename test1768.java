class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len = Math.min(word1.length(),word2.length());
        String res = "";
        for(int i= 0;i < len;i++){
            res += word1.charAt(i);
            res += word2.charAt(i);
        }
        if(len == word1.length()){
            for(int i = len;i<word2.length();i++){
                res += word2.charAt(i);
            }
        }else{
            for(int i = len;i<word1.length();i++){
                res += word1.charAt(i);
            }
        }
        return res;
    }
}