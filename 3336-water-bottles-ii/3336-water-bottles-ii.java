class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {


        int bottlesDrunk = numBottles;

        int empty = numBottles;

        int curr = numExchange;


        while(empty>= curr) {

            empty-= curr;
            curr++;
            empty++;

            bottlesDrunk++;
        }

        return bottlesDrunk;
        
    }
}