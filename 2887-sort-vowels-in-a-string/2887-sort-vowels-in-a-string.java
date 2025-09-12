class Solution {
    public String sortVowels(String s) {
        
      Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o', 'u', 'A','E','I','O','U'));

StringBuilder vowelsInS = new StringBuilder();
      for(int i =0; i<s.length();i++) {
        if(vowels.contains(s.charAt(i))) {
            vowelsInS.append(s.charAt(i));
        }
      }

      char [] vow = vowelsInS.toString().toCharArray();
      
      Arrays.sort(vow);

      int p = 0;
      char[] chars = s.toCharArray();

      for(int i =0; i<chars.length;i++) {
      if(vowels.contains(s.charAt(i))) {

        chars[i]= vow[p++];

        }
      }

         return new String(chars);
    }



}