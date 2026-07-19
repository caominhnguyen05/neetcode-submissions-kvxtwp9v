class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.isEmpty()) {
            return res;
        }

        String[] digitToChars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        backtrack(res, new StringBuilder(), 0, digits, digitToChars);
        return res;
    }

    private void backtrack(
        List<String> res, StringBuilder curr, int i, String digits, String[] digitToChars) {
        if (curr.length() == digits.length()) {
            res.add(curr.toString());
            return;
        }

        String chars = digitToChars[digits.charAt(i) - '0'];

        for (char c : chars.toCharArray()) {
            curr.append(c);
            backtrack(res, curr, i + 1, digits, digitToChars);
            curr.deleteCharAt(curr.length() - 1);
        } 
    }

    // Time: O(n * 4^n)
    // Space: O(n) extra space
}
