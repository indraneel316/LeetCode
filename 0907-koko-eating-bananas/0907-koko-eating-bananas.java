class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while(left<=right) {

            int mid = left + (right-left)/2;

            if(canEatAllPilesinhHours(piles, mid, h)) {
              right = mid-1;
            }

            else {
                left = mid+1;
            }
        }
        return left;
    }

        private boolean canEatAllPilesinhHours(int[] piles, int mid, int h) {

            int totalTime =0;

            for(int pile : piles) {

                totalTime+= (int) Math.ceil((double) pile/ mid);

                if(totalTime>h) {
                    return false;
                }

            }

            return true;
        }
        
    }
