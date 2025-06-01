class Solution {
    public boolean isAnagram(String s, String t) {

    Map<Character, Integer> vals = new HashMap<>();

  for (char c : s.toCharArray()) {
    vals.put(c, vals.getOrDefault(c,0)+1);
  }

 for(char c: t.toCharArray()) {
   if(!vals.containsKey(c) || vals.get(c) == 0) {
    return false;
   }
   vals.put(c, vals.get(c) -1);
  }

  for(Map.Entry<Character, Integer> entry : vals.entrySet()) {
    if(entry.getValue()!=0) {
        return false;
    }
  }
return true;
}
}