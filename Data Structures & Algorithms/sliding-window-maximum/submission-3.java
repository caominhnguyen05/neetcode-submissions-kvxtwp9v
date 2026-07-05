class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Stores indices in decreasing order of values
        Deque<Integer> q = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            // Remove elements smaller than current
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[r]) {
                q.pollLast();
            }

            // Add current index
            q.offerLast(r);

            // Remove elements outside window
            if (q.peekFirst() <= r - k) {
                q.pollFirst();
            }

            // Record answer once window is valid
            if (r >= k - 1) {
                result[r - k + 1] = nums[q.peekFirst()];
            }
        }

        return result;
    }
}
