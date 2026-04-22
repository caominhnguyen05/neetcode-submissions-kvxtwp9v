class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        String[] digitToChars = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(res, "", 0, digitToChars, digits);
        return res;
    }

    private void backtrack(List<String> res, String currStr, int i, String[] digitToChars, String digits) {
        if (i == digits.length()) {
            res.add(currStr);
            return;
        }

        String chars = digitToChars[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            backtrack(res, currStr + c, i + 1, digitToChars, digits);
        }
    }
}
