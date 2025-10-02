class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {


        int totalbottlesDrunk = numBottles; // 

        int empty = numBottles;

        int curr = numExchange;


        while(empty>= curr) {

            empty-= curr;
            curr++;
            empty++;

            totalbottlesDrunk++;
        }

        return totalbottlesDrunk;
        
    }
}