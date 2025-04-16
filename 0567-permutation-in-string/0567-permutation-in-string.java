class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        
        Map<Character, Integer> sMap1 = new HashMap<>();
        for(char c : s1.toCharArray()) {
            
            if(sMap1.containsKey(c)) {
                sMap1.put(c, sMap1.get(c)+1);
            }
            else {
                 sMap1.put(c, 1);
            }
        }
        
        int i =0;
        int j =0;
        int k = s1.length();
        
        int count = sMap1.size();
        
        while(j<s2.length()) {
            if(sMap1.containsKey(s2.charAt(j))) {
                sMap1.put(s2.charAt(j), sMap1.get(s2.charAt(j)) -1);
                if(sMap1.get(s2.charAt(j)) == 0) {
                    count--;
                }
            }
             
            if(j-i+1<k) {
                j++;
            }
            
            else if(j-i+1==k) {
                
                if(count ==0) {
                    return true;
                }
                
                if(sMap1.containsKey(s2.charAt(i))) {
                   sMap1.put(s2.charAt(i), sMap1.get(s2.charAt(i))+1);
                       if(sMap1.get(s2.charAt(i)) ==1) {
                           count++;
                       }
                }
                
                i++;
                j++;
            }
               } return false;}
               }
