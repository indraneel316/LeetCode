class Solution {
    public int maxSubArray(int[] nums) {
        int totalSum =0;
        int maxSum =Integer.MIN_VALUE;
        if(nums.length>1) {
        for(int i=0; i< nums.length;i++) {
            totalSum+=nums[i];
            maxSum = Math.max(totalSum, maxSum);
            if(totalSum<0) {
                totalSum=0;
            }
        }
         return maxSum;

    }
    else {
        return nums[0];

    }
    }
}