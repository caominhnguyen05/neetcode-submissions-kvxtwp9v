class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.push(i);
            } else if (c == '*') {
                star.push(i);
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                } else {
                    if (star.isEmpty()) {
                        return false;
                    }
                    star.pop();
                }
            }
        }

        while (!left.isEmpty() && !star.isEmpty()) {
            int leftIndex = left.pop();
            int starIndex = star.pop();

            if (leftIndex > starIndex) {
                return false;
            }
        }

        return left.isEmpty();
    }
}
