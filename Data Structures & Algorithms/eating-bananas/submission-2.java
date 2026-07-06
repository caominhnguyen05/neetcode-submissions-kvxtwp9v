class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(pile, right);
        }

        int res = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEat(mid, piles, h)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    private boolean canEat(int k, int[] piles, int h) {
        int hours = 0;

        for (int pile : piles) {
            if (pile % k == 0) {
                hours += pile / k;
            } else {
                hours += (pile / k) + 1;
            }
            if (hours > h) {
                return false;
            }
        }

        return true;
    }
}
