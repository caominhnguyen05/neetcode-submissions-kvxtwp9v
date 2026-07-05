class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int r = 0; r < n; r++) {
            maxHeap.offer(new int[]{nums[r], r});

            if (r >= k - 1) {
                while (maxHeap.peek()[1] <= r - k) {
                    maxHeap.poll();
                }

                result[r - k + 1] = maxHeap.peek()[0];
            }
        }

        return result;
    }
}
