class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int right =0;
        Set<Character> track = new HashSet<>();
        int maxLen = 0;
        while(right< s.length()) {
            // Calculations
            // Increase Window Size
            if(!track.contains(s.charAt(right))) {
                track.add(s.charAt(right));
                maxLen = Math.max(maxLen, track.size());
                 right++;
            }

            else {
                // Slide from left 
                track.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
        
    }
}