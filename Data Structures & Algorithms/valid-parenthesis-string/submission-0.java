class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> stars = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open.push(i);
            } else if (c == '*') {
                stars.push(i);
            } else {
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!stars.isEmpty()) {
                    stars.pop();
                } else {
                    return false;
                }
            }
        }

        while (!open.isEmpty()) {
            if (!stars.isEmpty()) {
                if (stars.peek() < open.peek()) {
                    return false;
                } else {
                    open.pop();
                    stars.pop();
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
