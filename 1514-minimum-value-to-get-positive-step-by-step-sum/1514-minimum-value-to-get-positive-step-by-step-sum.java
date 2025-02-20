class Solution {
    public int minStartValue(int[] nums) {


        int currSum =0;
        int minVal =0;
        int flag =0;

        for(int i=0; i<nums.length;i++) {
         currSum+= nums[i];
         if(nums[i]<0 && currSum<0) {
            flag =1;
            minVal= Math.min((currSum), minVal);
        }
        }

        if(flag==0) {
            return 1;
        }

        return (minVal*-1)+1;
        
    }
}