class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int matchedChar = 0; // how many characters have the correct frequency
        int required = tMap.size(); // number of characters required to have correct frequency
        int minLength = s.length() + 1;
        int start = -1;

        Map<Character, Integer> sMap = new HashMap<>();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);

            if (sMap.get(c).equals(tMap.get(c))) {
                matchedChar += 1;
            }

            while (matchedChar == required) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Shrink window from the left
                char charLeft = s.charAt(left);
                if (tMap.containsKey(charLeft) && sMap.get(charLeft).equals(tMap.get(charLeft))) {
                    matchedChar -= 1;
                }
                sMap.put(charLeft, sMap.get(charLeft) - 1);
                left++;
            }
        }

        return minLength == s.length() + 1 ? "" : s.substring(start, start + minLength);
    }
}
