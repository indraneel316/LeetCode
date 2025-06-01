class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] result = new int[nums.length];
        int prefix=1;
        int postfix =1;

        // Arrays.fill(result,1);
         
        for(int i=0; i< nums.length;i++) {
            result[i] = prefix;
            prefix = prefix*nums[i];
        }
        // nums = [1,2,3,4]
        
        // result = [1,1,2,6]

        for(int i = nums.length-1; i>=0; i--) {

            result[i] = result[i]*postfix; 
            postfix = postfix*nums[i]; 
        }

        return result;
    }
}