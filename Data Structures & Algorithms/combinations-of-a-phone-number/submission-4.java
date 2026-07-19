class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();

        if (digits.isEmpty()) {
            return res;
        }
        
        backtrack(res, new StringBuilder(), 0, digits, map);
        
        return res;
    }

    private void backtrack(
        List<String> res, StringBuilder curr, int i, String digits, Map<Character, String> map) {
        if (curr.length() == digits.length()) {
            res.add(curr.toString());
            return;
        }

        char digit = digits.charAt(i);
        String chars = map.get(digit);

        for (char c : chars.toCharArray()) {
            curr.append(c);
            backtrack(res, curr, i + 1, digits, map);
            curr.deleteCharAt(curr.length() - 1);
        } 
    }
}
