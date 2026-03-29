class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0;
        int right = n - 1;
        int maxArea = 0;

        while (left < right) {
            int currArea = Math.min(heights[left], heights[right]) * (right - left);
            maxArea = Math.max(maxArea, currArea);

            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
