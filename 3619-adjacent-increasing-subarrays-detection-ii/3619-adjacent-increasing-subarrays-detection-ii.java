class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;
        int prev = 0; // length of the previous increasing run
        int curr = 0; // length of the current increasing run

        for (int i = 0; i < n; i++) {
            curr++; // every element extends the current run by 1

            // if the next element breaks the increase or we're at the end
            if (i == n - 1 || nums.get(i) >= nums.get(i + 1)) {
                // split one long increasing run into two halves
                // (handles cases like [1,2,3,4,5,6] → k = 3)
                ans = Math.max(ans, curr / 2);

                // combine two consecutive increasing runs
                // (handles cases like [2,5,7,8,9,2,3,4] → k = min(5,3) = 3)
                ans = Math.max(ans, Math.min(prev, curr));

                // store this run as previous and reset for next run
                prev = curr;
                curr = 0;
            }
        }

        return ans;
    }
}
