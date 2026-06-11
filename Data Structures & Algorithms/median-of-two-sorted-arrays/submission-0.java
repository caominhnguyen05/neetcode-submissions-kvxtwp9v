class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        while (low <= high) {
            // Partition in nums1
            int i = low + (high - low) / 2;

            // Corresponding partition in nums2
            int j = (m + n + 1) / 2 - i;

            // Values around partition
            int l1 = (i == 0) ? Integer.MIN_VALUE : nums1[i-1];
            int r1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int l2 = (j == 0) ? Integer.MIN_VALUE : nums2[j-1];
            int r2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Correct partition found
            if (l1 <= r2 && l2 <= r1) {
                // Odd total length
                if ((m + n) % 2 == 1) {
                    return Math.max(l1, l2);
                }

                // Even total length
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }

            // Move partition left
            if (l1 > r2) {
                high = i - 1;
            }
            // Move partition right
            else {
                low = i + 1;
            }
        }

        return 0.0;
    }
}
