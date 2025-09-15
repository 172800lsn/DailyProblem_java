class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int n = words.length;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < brokenLetters.length(); i++){
            map.put(brokenLetters.charAt(i), 1);
        }
        for(int i = 0; i < n; i++){
            char[] arr = words[i].toCharArray();
            for(int j = 0;j < arr.length; j++){
                if(map.containsKey(arr[j])){
                    res++;
                    break;
                }
            }
        }
        return n-res;
    }
}