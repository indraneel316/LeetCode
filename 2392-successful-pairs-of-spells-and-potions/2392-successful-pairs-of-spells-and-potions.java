class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        

        Arrays.sort(potions);

        int [] ans = new int[spells.length];

        int j =0;

        int k =0;


        for(int i =0; i<spells.length;i++) {

          ans[j++] = getPairCount(spells[i], potions, success);

        }

        return ans;
    }


    public int getPairCount(int spell, int [] potions, long success) {


        int low = 0;
        int high = potions.length -1;

        while(low<=high) {

            int mid = low + (high - low)/2; 

            if((long) spell*potions[mid]< success) {

                low = mid+1;
            }

            else {

                high = mid-1;
            }

        }

        return potions.length - low;


    }
}