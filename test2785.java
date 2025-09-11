class Solution {
    public String sortVowels(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] vowel = new int[n];
        int[] vowelIndex = new int[n];
        int vowelCount = 0;
        for (int i = 0; i < n; i++) {
            if (isVowel(chars[i])) {
                vowel[vowelCount] = chars[i];
                vowelIndex[vowelCount] = i;
                vowelCount++;
            }
        }
        Arrays.sort(vowel, 0, vowelCount);
        for (int i = 0; i < vowelCount; i++) {
            chars[vowelIndex[i]] = (char) vowel[i];
        }
        return new String(chars);
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}