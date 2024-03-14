class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hmap = new HashMap<>();
        for(int i =0; i<s.length();i++) {
            if(hmap.containsKey(s.charAt(i))) {
                if(!hmap.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
            }
            else {
                if(hmap.containsValue(t.charAt(i))) {
                    return false;
                }
                hmap.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
        }}