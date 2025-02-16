class Solution {
    public double myPow(double x, int n) {
        
        long copy = n;
        if(copy<0) {

            copy = -1*copy;
        }

        double answer =1.0;
        while(copy>0) {
            if(copy%2==1) {
                answer = x*answer;
                copy = copy-1;
            }
            else {
                x = x*x;
                copy = copy/2;
            }
        }

        if(n<0) {

            return (double) 1/(double)answer;
        }

        return answer;

    }
}