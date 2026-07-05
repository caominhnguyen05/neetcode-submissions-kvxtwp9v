class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        // Monotonically decreasing stack
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }
}
