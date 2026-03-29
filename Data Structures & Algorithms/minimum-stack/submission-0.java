class MinStack {
    private Deque<Integer> minStack;
    private Deque<Integer> stack;

    public MinStack() {
        minStack = new ArrayDeque<>();
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            if (val <= minStack.peek()) {
                minStack.push(val);
            }
        }
    }
    
    public void pop() {
        int popVal = stack.pop();
        
        if (popVal == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
