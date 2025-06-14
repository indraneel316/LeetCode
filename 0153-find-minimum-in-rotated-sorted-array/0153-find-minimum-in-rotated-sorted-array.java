class Solution {
    public int findMin(int[] nums) {

        int left =0;
        int right = nums.length-1;

        if(nums[left]<nums[right]) {
            return nums[left];

        }

        while(left<right){

            int mid = left+(right-left)/2;

            if(nums[mid]< nums[right]) { // right half sorted so we check the left
                right = mid;
            }

            else if(nums[mid]> nums[right]){ // left half sorted so we check right

                left = mid+1;

            }

            else {  // decrement right if same
                right--;
            }

        }
        return nums[left];
        
    }
}