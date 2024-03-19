class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if (nums.length ==0) {
            return 0;
        }
        for(int i =0; i<nums.length;i++) {
            set.add(nums[i]);
        }
        int largestSeq =1;
        int currSeq =1;
        for(int num: nums) {
            if(!set.contains(num-1)) {
                currSeq =1;
             while(set.contains(num+1)) {
                 num++;
                 currSeq++;     
            }
            }
            if(largestSeq<currSeq) {
                largestSeq = currSeq;
            }
        }
          return largestSeq;
    }
      
}