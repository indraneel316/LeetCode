class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {

        

        int emptyBottles = numBottles;

        int count = 0;

        int count2 =0;

        while(emptyBottles >= numExchange && emptyBottles>0) {

            emptyBottles = emptyBottles - numExchange;

            count++;

            emptyBottles+= count;

            count2++;

            count =0;
        }

        return numBottles + count2;

        
    }
}