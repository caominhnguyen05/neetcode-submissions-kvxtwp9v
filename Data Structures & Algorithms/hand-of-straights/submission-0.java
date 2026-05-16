class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : hand) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for (int num : hand) {
            // Attempt to form a group from x to x + groupSize - 1
            if (counts.containsKey(num)) {
                for (int i = num; i <= num + groupSize - 1; i++) {
                    if (!counts.containsKey(i)) {
                        return false;
                    }

                    counts.put(i, counts.get(i) - 1);
                    if (counts.get(i) == 0) {
                        counts.remove(i);
                    }
                }
            }
        }

        return true;
    }
}
