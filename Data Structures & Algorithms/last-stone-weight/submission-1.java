class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int max = maxHeap.poll();
            int secondMax = maxHeap.poll();

            if (secondMax < max) {
                maxHeap.add(max - secondMax);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
