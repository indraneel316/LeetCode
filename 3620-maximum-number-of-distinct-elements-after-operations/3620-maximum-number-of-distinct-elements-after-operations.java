class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        

        long current = Long.MIN_VALUE;

        Arrays.sort(nums);
        //pick one valid non picked unique element for each num once which is within a range of num-k and num+k

        int res =0;

        for(int num : nums) {

            long target  = Math.max(current+1, num-k); // to stay in limits
            
            if(target<= num+k) {

                current = target; //pick 1 value per element
                res++;
            }

            else {
                current = Math.max(current, num); // move to the next element if no value can be picked within the range
            }

        }
            return res;

        }

    }