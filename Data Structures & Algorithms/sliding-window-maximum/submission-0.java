class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Monotonically decreasing queue
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }

            queue.offerLast(i);

            // If the index at the front is outside the current window, remove it
            if (queue.getFirst() <= i - k) {
                queue.removeFirst();
            }

            if (i >= k - 1) {
                result[i - k + 1] = nums[queue.getFirst()];
            }
        }

        return result;
    }
}
