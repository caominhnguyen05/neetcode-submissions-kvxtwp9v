class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int leftWall = 0;
        int rightWall = 0;

        for (int i = 0; i < n; i++) {
            leftMax[i] = leftWall;
            leftWall = Math.max(leftWall, height[i]);

            rightMax[n-i-1] = rightWall;
            rightWall = Math.max(rightWall, height[n-i-1]);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (water > 0) {
                result += water;
            }
        }

        return result;
    }
}
