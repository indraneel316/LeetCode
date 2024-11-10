class Solution {
    public void nextPermutation(int[] nums) {

        int idealIndex =-1;
        // find the break point
        int len = nums.length;
        for(int i=len-2; i>=0;i--) {
            if(nums[i]<nums[i+1]) {
                idealIndex = i;
                break;
            }
        }
        if(idealIndex!=-1) {
        for(int i= len-1; i>=idealIndex; i--) {
            if(nums[i] > nums[idealIndex]) {
                int temp = nums[i];
                nums[i] = nums[idealIndex];
                nums[idealIndex] = temp;
                break;
            }
        }


        int p1 = idealIndex+1; 
        int p2 = nums.length-1;

        while(p1 < p2) {
            int temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
            p1++;
            p2--;
        }        
        }
        else {
            
        int p1 = 0; 
        int p2 = nums.length-1;

        while(p1<p2) {
            int temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
            p1++;
            p2--;
        }
        }

        
    }
}