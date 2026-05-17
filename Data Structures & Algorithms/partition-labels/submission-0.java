class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastPos = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            lastPos.put(s.charAt(i), i);
        }

        List<Integer> ans = new ArrayList<>();

        int currLength = 0;
        int lastPosThisSubstring = 0;

        for (int i = 0; i < s.length(); i++) {
            currLength++;

            char c = s.charAt(i);
            lastPosThisSubstring = Math.max(lastPosThisSubstring, lastPos.get(c));
            if (lastPosThisSubstring == i) {
                ans.add(currLength);
                currLength = 0;
                lastPosThisSubstring = i + 1;
            }
        }

        return ans;
    }
}
