class Solution {
    public boolean isPalindrome(String s) {
        
 s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();        
        System.out.println(s);
        char [] a = s.toCharArray();
        char [] b = new char[a.length];
        int pointer =0;
        for(int i= b.length-1;i>=0;i--) {
            b[i] = a[pointer];
            pointer++;
        }
        for(int i =0; i<a.length;i++) {
            if(a[i]!=b[i]) {
                return false;
            }
        }
        return true;
    }
}