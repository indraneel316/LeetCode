class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int i =0; i<nums.length;i++) {
            set.add(nums[i]);
        }
        
        for(Integer num : set) {
            if(!set.contains(num-1)) {

                int count =1;
                int num2 = num+1;
                while(set.contains(num2++)){
                    count++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}