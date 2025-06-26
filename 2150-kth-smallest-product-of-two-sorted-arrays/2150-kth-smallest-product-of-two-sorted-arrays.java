import java.util.Arrays;

class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        // Define search space: the smallest and largest possible product
        // -10^10 to 10^10 covers all possible product ranges safely
        long left = -1_000_000_0000L;  // Smallest possible product
        long right = 1_000_000_0000L;  // Largest possible product

        // Binary search over the product value space
        while (left < right) {
            long mid = left + (right - left) / 2;  // Prevent overflow

            // Count how many products are <= mid
            if (countProducts(nums1, nums2, mid) < k) {
                // Not enough products ≤ mid → we need to search higher
                left = mid + 1;
            } else {
                // Enough or too many products → try smaller
                right = mid;
            }
        }

        // When left == right, we found the k-th smallest product
        return left;
    }

    // Helper function to count how many pairs (a * b) are ≤ target
    private long countProducts(int[] nums1, int[] nums2, long target) {
        long count = 0;

        for (int num1 : nums1) {
            // Case 1: num1 is zero
            if (num1 == 0) {
                // 0 * any number = 0 → so all products are ≤ target if target ≥ 0
                if (target >= 0) count += nums2.length;
                continue; // skip to next num1
            }

            // Case 2: num1 is positive
            if (num1 > 0) {
                // Binary search for the largest index j such that num1 * nums2[j] ≤ target
                int low = 0, high = nums2.length;
                while (low < high) {
                    int mid = (low + high) / 2;
                    if ((long) num1 * nums2[mid] <= target) {
                        low = mid + 1;  // try right half
                    } else {
                        high = mid;     // try left half
                    }
                }
                count += low;  // low = count of valid nums2 values

            } else {
                // Case 3: num1 is negative
                // We want num1 * nums2[j] ≤ target
                // Since num1 is negative, as nums2[j] increases, product decreases
                // So we binary search from the other side
                int low = 0, high = nums2.length;
                while (low < high) {
                    int mid = (low + high) / 2;
                    if ((long) num1 * nums2[mid] <= target) {
                        high = mid;     // look to the left for smaller nums2[j]
                    } else {
                        low = mid + 1;  // product too big → move right
                    }
                }
                // nums2.length - low = count of valid nums2[j] values for this negative num1
                count += nums2.length - low;
            }
        }

        return count;
    }
}
