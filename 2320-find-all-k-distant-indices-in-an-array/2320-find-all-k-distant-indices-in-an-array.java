class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        int left =0;
        int right =0;
        List<Integer> res = new ArrayList<>();
        while (left < nums.length && right < nums.length) {

            if (nums[right] != key) {
                right++;
            }
            else if (left < right - k) {
                // left is too far left, move it closer to key
                left++;
            }
            else if (left > right + k) {
                // left passed the right's range, move right to next key
                right++;
            }
            else {
                // left within [right - k, right + k], add left and move forward
                res.add(left);
                left++;
            }
        }
        return res;
        
    }
}