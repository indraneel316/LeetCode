 class Solution {
    public int trap(int[] height) {
        
        int left =0;
        int right = height.length-1;
        int leftMax = height[left];
        int rightMax =height[right];
        int total =0;

        while(left<right) {

            if(leftMax<=rightMax) {
                left++;
                leftMax =Math.max(leftMax, height[left]);
                total+= leftMax - height[left];
            }
            else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                total+= rightMax - height[right];
        }
        
    }
    return total;
}
 }