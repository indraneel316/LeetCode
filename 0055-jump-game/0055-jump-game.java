class Solution {
    public boolean canJump(int[] nums) {
        
       
       int end = 0;
       for(int i =0; i<nums.length; i++ ) {
        if(i > end) {
            return false;

        }
        end = Math.max(end, i + nums[i]);
    

       }

       return true;
      
    }
}