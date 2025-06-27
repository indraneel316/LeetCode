class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Collect valid characters (those with freq ≥ k)
        List<Character> candidates = new ArrayList<>();
        for (int i = 25; i >= 0; i--) {  // reverse for lexicographical priority
            if (freq[i] >= k) {
                candidates.add((char) ('a' + i));
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        String best = "";

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            for (char ch : candidates) {
                String next = curr + ch;
                if (isKSubsequence(s, next, k)) {
                    queue.offer(next);
                    if (next.length() > best.length() || 
                       (next.length() == best.length() && next.compareTo(best) > 0)) {
                        best = next;
                    }
                }
            }
        }

        return best;
    }

    // Check if target repeated k times is a subsequence of s
    private boolean isKSubsequence(String s, String target, int k) {
        int i = 0, total = target.length() * k;
        for (char c : s.toCharArray()) {
            if (c == target.charAt(i % target.length())) {
                i++;
                if (i == total) return true;
            }
        }
        return false;
    }
}