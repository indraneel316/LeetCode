class Solution {
    public int maxArea(int[] nums) {

        int left =0;
        int right = nums.length-1;
        int maxArea = Integer.MIN_VALUE;
        while(left< right) {

            if(nums[left]<nums[right]) {
                maxArea = Math.max(maxArea, nums[left]* (right-left));
                left++;
            }

            else {
                maxArea = Math.max(maxArea, nums[right]* (right-left));
                right--;
            }
        }

        return maxArea;
        
    }
}