class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int key : counts.keySet()) {
            pq.offer(new int[]{key, counts.get(key)});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[pq.size()];
        int index = 0;
        while (!pq.isEmpty()) {
            res[index++] = pq.poll()[0];
        }

        return res;
    }

    // Time complexity: O(nlogk)
    // Space complexity: O(n + k)
    // n is the length of the array and k is the number of top frequent elements
}
