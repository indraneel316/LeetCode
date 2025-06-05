class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int left =0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        
        int [] freq = new int[58];

        int count = t.length();

         String result ="";

        for(char c : t.toCharArray()) {
            freq[c -'A']++;
        }
        while(right<s.length()) {

            char rightChar = s.charAt(right);

            if(freq[rightChar -'A'] > 0) {

                count--;
            }
            freq[rightChar-'A']--;

            right++;

        
            while(count == 0) {

                if(right-left<minLen) {
                    minLen = right-left;
                    result = s.substring(left,right);
                }

               char leftChar = s.charAt(left);
               freq[leftChar - 'A']++;
               if(freq[leftChar - 'A'] > 0) {
                count++;
               }
               left++;
            }
        }

        return result;

}
}