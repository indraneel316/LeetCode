class Solution {
    public int finalValueAfterOperations(String[] operations) {


        int x =0;

        for(String s: operations) {

            if(s.equals("--X") || s.equals("X--")) {

                x-=1;
            }

            else if(s.equals("++X") || s.equals("X++")) {

                x+=1;
            }

        }

        return x;
        
    }
}