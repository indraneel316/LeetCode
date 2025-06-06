class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {


        Deque<Integer> maxVals = new ArrayDeque<>();

        int left =0;
        int right = 0;

        int [] result = new int[nums.length-k+1];
        int idx =0;

        while(right< nums.length) {

            while(!maxVals.isEmpty() && nums[maxVals.peekLast()]< nums[right]) {
                maxVals.pollLast();
            }

            maxVals.offerLast(right);

            if(maxVals.peekFirst()<left) {
                maxVals.pollFirst();
            }

            if(right-left+1==k) {
                result[idx++] = nums[maxVals.peekFirst()];
                  left++;
            }
    

            right++;
            
        }
        return result;
        
    }
}