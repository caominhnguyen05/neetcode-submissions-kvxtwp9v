class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        for (int num : nums) {
            // Start a new consecutive subsequence
            if (!set.contains(num - 1)) {
                int length = 0;
                while (set.contains(num)) {
                    length++;
                    maxLength = Math.max(length, maxLength);
                    num++;
                }
            }
        }

        return maxLength;
    }
}
