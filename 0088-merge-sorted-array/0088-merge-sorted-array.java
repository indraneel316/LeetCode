class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

            int i = m - 1; // Pointer for last valid element in nums1
        int j = n - 1; // Pointer for last element in nums2
        int k = m + n - 1; // Pointer for placing elements in nums1 from the end

        // Merge from the end to avoid overwriting elements in nums1
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 still has elements left, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
}
}