class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (!set.contains(num - 1)) {
                int startNum = num;
                int length = 1;
                while (set.contains(startNum + 1)) {
                    length++;
                    startNum++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
