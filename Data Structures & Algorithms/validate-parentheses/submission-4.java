class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!pairs.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
