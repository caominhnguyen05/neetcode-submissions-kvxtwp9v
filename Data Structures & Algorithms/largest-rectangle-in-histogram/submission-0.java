class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        // Montonically increasing stack storing indices of heights
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            // At i == n, we forced all remaining bars to be processed
            int currHeight = i == n ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > currHeight) {
                int height = heights[stack.pop()];

                int leftSmallerIndex = stack.isEmpty() ? -1 : stack.peek();
                int rightSmallerIndex = i;

                int area = (rightSmallerIndex - leftSmallerIndex - 1) * height;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}