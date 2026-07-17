class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        this.left = new PriorityQueue<>((a, b) -> b - a); // small elements - max heap
        this.right = new PriorityQueue<>(); // large elements - minHeap
    }
    
    public void addNum(int num) {
        left.add(num);

        if (left.size() - right.size() > 1) {
            right.add(left.poll());
        }

        if (!right.isEmpty() && left.peek() > right.peek()) {
            right.add(left.poll());
        }

        if (right.size() > left.size()) {
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        }

        return (left.peek() + right.peek()) / 2.0;
    }

    // Time: O(m * logn) for addNum(), O(m) for findMedian
    // Space: O(n)
    // m is the number of function calls and n is the length of the array
}
