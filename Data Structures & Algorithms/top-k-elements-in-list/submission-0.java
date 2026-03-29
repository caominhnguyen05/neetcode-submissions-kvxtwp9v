class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int num : counts.keySet()) {
            pq.offer(new int[]{num, counts.get(num)});
            if (pq.size() > k) {
                pq.poll();
            }
        } 

        int[] result = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            result[i] = pq.poll()[0];
            i++;
        }

        return result;
    }
}
