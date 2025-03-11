class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<nums.length;i++) {

            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            for(int j = i+1; j<nums.length; j++) {
                if(j!=(i+1) && nums[j] == nums[j-1]) {
                    continue;
                }

                int left = j+1;
                int right = nums.length-1;
                while(left< right) {
                    long currSum = (long) nums[i]+nums[j]+nums[left]+nums[right];
                    if(currSum == target) {
                        List<Integer> pairs = new ArrayList<>();
                        pairs.add(nums[i]);
                        pairs.add(nums[j]);
                        pairs.add(nums[left]);
                        pairs.add(nums[right]);
                        res.add(pairs);

                        while(left<right && nums[left] == nums[left+1]) left++;
                        while(left<right && nums[right] ==  nums[right-1]) right--;
                                     left++;
                        right--;
                    }
                    else if(currSum<target) {
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
            
        }
        return res;
    }
}