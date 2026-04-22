class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), 0, s);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> curr, int startIndex, String s) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int endIndex = startIndex; endIndex < s.length(); endIndex++) {
            String substring = s.substring(startIndex, endIndex + 1);
            
            if (isPalindrome(substring)) {
                curr.add(substring);
                backtrack(res, curr, endIndex + 1, s);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
