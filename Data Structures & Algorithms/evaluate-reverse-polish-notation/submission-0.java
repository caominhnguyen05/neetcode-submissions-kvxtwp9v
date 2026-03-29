class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String s : tokens) {
            switch (s) {
                case "+":
                    int sum = stack.pop() + stack.pop();
                    stack.push(sum);
                    break;
                case "-":
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second - first);
                    break;
                case "*":
                    int product = stack.pop() * stack.pop();
                    stack.push(product);
                    break;
                case "/":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second / first);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }

        return stack.pop();
    }
}
