class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        List<Character> candidateChars = new ArrayList<>();
        for (int i = 25; i >= 0; i--) {
            if (freq[i] >= k) {
                candidateChars.add((char)(i + 'a'));
            }
        }

        // BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        String result = "";

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            for (char c : candidateChars) {
                String next = cur + c;
                if (isValid(next, s, k)) {
                    queue.offer(next);
                    if (next.length() > result.length() || (next.length() == result.length() && next.compareTo(result) > 0)) {
                        result = next;
                    }
                }
            }
        }

        return result;
    }
    private boolean isValid(String candidate, String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) sb.append(candidate);
        String repeated = sb.toString();
        int i = 0, j = 0;
        while (i < repeated.length() && j < s.length()) {
            if (repeated.charAt(i) == s.charAt(j)) i++;
            j++;
        }
        return i == repeated.length();
    }
}
