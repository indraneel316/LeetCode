class Solution {
    public int majorityElement(int[] nums) {
        
        int n = nums.length;
        int count =0;
        int ele =0;
        for(int i =0;i<n;i++) {

            if(count==0) {
                ele = nums[i];
                count =1;
            }
            else if(nums[i]==ele) {
                count++;
            }
            else {
                count--;
            }
        }

        int cnt1 =0;
        for(int i =0; i<n;i++) {
            if(ele== nums[i]) {
                cnt1++;
            }
        }
        if(cnt1>(n/2)) {
            return ele;
        }
        return -1;

    }
}