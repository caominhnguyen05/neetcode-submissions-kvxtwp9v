class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;

        String[] digitToChars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        backtrack(res, new StringBuilder(), digitToChars, 0, digits);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder curr, String[] digitToChars, int index, String digits) {
        if (curr.length() == digits.length()) {
            res.add(curr.toString());
            return;
        }

        String chars = digitToChars[digits.charAt(index) - '0'];
        for (char c : chars.toCharArray()) {
            curr.append(c);
            backtrack(res, curr, digitToChars, index + 1, digits);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    // Time complexity: O(n * 4^n)
    // Space complexity: O(n) extra space, O(n * 4^n) space for the output list
}
