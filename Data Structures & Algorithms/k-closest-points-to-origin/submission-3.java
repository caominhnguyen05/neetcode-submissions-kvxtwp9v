class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> distance(b) - distance(a));

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int idx = 0;

        while (!maxHeap.isEmpty()) {
            res[idx] = maxHeap.poll();
            idx++;
        }

        return res;
    }

    private int distance(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }

    // Time: O(n * logk)
    // Space: O(k)
}
