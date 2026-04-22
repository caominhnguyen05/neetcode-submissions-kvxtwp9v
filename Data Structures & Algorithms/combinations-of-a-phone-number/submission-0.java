class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> res = new ArrayList<>();

        if (digits.isEmpty()) {
            return res;
        }
        
        backtrack(res, new StringBuilder(), 0, map, digits);

        return res;
    }

    private void backtrack(List<String> res, StringBuilder curr, int i, Map<Character, List<Character>> map, String digits) {
        if (i == digits.length()) {
            res.add(curr.toString());
            return;
        }

        List<Character> chars = map.get(digits.charAt(i));

        for (char c : chars) {
            curr.append(c);
            backtrack(res, curr, i + 1, map, digits);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
