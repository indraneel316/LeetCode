class Solution {
    public int findSmallestInteger(int[] nums, int value) {

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            int rem = ((num % value) + value) % value; // if negative number (+value) pushes to positive, if after mod number already positive no imact
            freq.put(rem, freq.getOrDefault(rem, 0) + 1);
        }

        // Step 2: find smallest missing integer (MEX)
        int mex = 0;
        while (true) {
            int rem = mex % value;  // key step to find which bucket / group can generate mex and if space is available to generate
            if (freq.getOrDefault(rem, 0) > 0) {
                freq.put(rem, freq.get(rem) - 1); // use one from that group
                mex++;
            } else {
                break; // can't form this number
            }
        }

        return mex;
}
}