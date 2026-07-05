class Solution {
    public int largestRectangleArea(int[] heights) {
        // Idea: For each bar, find the area of the rectangle 
        // with that bar being the shortest bar

        int n = heights.length;

        // Monotonically increasing stack storing indices of bars
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
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
