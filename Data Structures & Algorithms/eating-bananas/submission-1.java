class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1;
        int right = max;
        int result = right; // worst case: eat largest pile per hour

        while (left <= right) {
            int mid = left + (right - left) / 2;    

            if (canEat(mid, piles, h)) {
                // valid speed, try smaller to minimize k
                result = mid;
                right = mid - 1;
            } else {
                // too slow, need higher speed
                left = mid + 1;
            }
        }

        return result;
    }

    // Check if we can finish all piles within h hours at speed k
    private boolean canEat(int k, int[] piles, int h) {
        long hoursSpent = 0;

        for (int pile : piles) {
            hoursSpent += Math.ceil((double) pile / k);
            if (hoursSpent > h) {
                return false;
            }
        }

        return true;
    }

    // Time complexity: O(n log m)
    // n = number of piles, m = max pile size
}
