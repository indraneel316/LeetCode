class Solution {
    public boolean hasSameDigits(String s) {
    

    String s1 = s;

    int i =1;

    String processed = "";
    while(s1.length()>2) {
        int sum = (s1.charAt(i-1) - '0') + (s1.charAt(i) - '0');
        int res = sum % 10; 
        processed+= res;
        if(i==s1.length()-1) {
            s1 = processed;
            processed = "";
            System.out.println("TRACK DATA "+ s1);
            i = 0;
        }
       i++;


    }

    if(s1.charAt(0) == s1.charAt(1)) {
        return true;
    }
    
    return false;
}
}