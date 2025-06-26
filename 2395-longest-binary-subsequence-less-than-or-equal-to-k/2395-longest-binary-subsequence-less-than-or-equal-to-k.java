class Solution {
    public int longestSubsequence(String s, int k) {



        int count =0;

        int len = 0;

        StringBuilder sb = new StringBuilder();


        for(int i = s.length()-1; i>=0;i--) {

            sb.insert(0, s.charAt(i));
            String temp = sb.toString();
            if(calculateBinary(temp)!= -1 && calculateBinary(temp)<=k) {
                count++;
                len = Math.max(len, count);
            }
            else {
                sb.deleteCharAt(0);
                continue;
            }
        }
      return len;
    }


    public long calculateBinary(String val) {

        try {

            long num = Long.parseLong(val, 2);

            return num;
        }

        catch(Exception e) {

            return -1L;
        }
    }   
}