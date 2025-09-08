class Solution {
    public int[] getNoZeroIntegers(int n) {
        

        int a =1;
        int b =1;

       
        while(ifZeros(n-b)) {
            b++;
        }
        a = n-b;

       if(!ifZeros(b)) {
          return new int [] {a, b};
       }

       else {
        while(ifZeros(n-a)) {
            a--;
            b++;
        }
       }

       return new int [] {a, b};
       
      
    }


    public boolean ifZeros(int val) {

     String val2 = String.valueOf(val);

     if(val2.contains("0")) {
        return true;
     }

     return false;

    }
}