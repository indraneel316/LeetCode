class Solution {
       public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        // Use a very small value to represent "invalid" or unreached states.
        // Given constraints, the sum can range from -10^14 to 10^14.
        long INF = (long) 1e16;
        long s1 = -INF, s2 = -INF, s3 = -INF;
        long maxResult = -INF;

        for (int i = 1; i < n; i++) {
            long nextS1 = -INF, nextS2 = -INF, nextS3 = -INF;

            if (nums[i] > nums[i - 1]) {
                // Strictly Increasing: Start a new S1 or continue an existing one
                nextS1 = Math.max((long)nums[i - 1] + nums[i], s1 == -INF ? -INF : s1 + nums[i]);
                // Strictly Increasing: Transition from S2 (Up-Down) to S3 (Up-Down-Up) or continue S3
                if (s2 != -INF || s3 != -INF) {
                    nextS3 = Math.max(s2, s3) + nums[i];
                }
            } else if (nums[i] < nums[i - 1]) {
                // Strictly Decreasing: Transition from S1 (Up) to S2 (Up-Down) or continue S2
                if (s1 != -INF || s2 != -INF) {
                    nextS2 = Math.max(s1, s2) + nums[i];
                }
            }
            // If nums[i] == nums[i-1], strictness is broken; next states remain -INF

            s1 = nextS1;
            s2 = nextS2;
            s3 = nextS3;
            
            // Track the maximum sum found for a complete trionic subarray
            if (s3 > maxResult) {
                maxResult = s3;
            }
        }

        return maxResult;
    }
}

