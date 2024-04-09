class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> track = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;

        while (right < s.length()) {
            if (!track.contains(s.charAt(right))) {
                track.add(s.charAt(right));
                maxLength = Math.max(maxLength, track.size());
                right++;
            } else {
                track.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }
}