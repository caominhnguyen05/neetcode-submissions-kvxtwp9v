class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();

        // character -> last index of this character in s
        Map<Character, Integer> lastPos = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            lastPos.put(c, i);
        }

        List<Integer> res = new ArrayList<>();
        int currStart = 0;
        int currEnd = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            currEnd = Math.max(currEnd, lastPos.get(c));

            if (i == currEnd) {
                res.add(currEnd - currStart + 1);
                currStart = currEnd + 1;
                currEnd = currStart;
            }
        }

        return res;
    }
}
