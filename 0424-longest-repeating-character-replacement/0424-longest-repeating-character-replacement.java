class Solution {
    public int characterReplacement(String s, int k) {
        
        
        int i=0;
        int j=0;
        int maxLen = Integer.MIN_VALUE;
        int maxFreq = Integer.MIN_VALUE;
        Map<Character, Integer> hmap = new HashMap<>();
        // for(char c: s.toCharArray()) {
        //     if(hMap.contains(c)) {
        //         hMap.put(c, hMap.get(c)+1);
        //     }
        // }
        
        while(j<s.length()) {
            if(hmap.containsKey(s.charAt(j))) {
                hmap.put(s.charAt(j), hmap.get(s.charAt(j)) +1);
            }
            else {
              hmap.put(s.charAt(j),1);
            }
            maxFreq = Math.max(maxFreq, hmap.get(s.charAt(j)));
            
            if((j-i)+1- maxFreq>k) {
            if(hmap.containsKey(s.charAt(i))) {
                hmap.put(s.charAt(i), hmap.get(s.charAt(i)) -1);
            }
                maxFreq = 0;
                i++;
                j++;
            }
            
            else if((j-i)+1 -maxFreq<=k) {
                maxLen = Math.max(maxLen, j-i+1);
                j++;
            }
            
            
        }
        return maxLen;
    }
}