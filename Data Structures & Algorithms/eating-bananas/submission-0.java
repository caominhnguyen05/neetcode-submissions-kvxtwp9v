class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1;
        int right = max;
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;    

            // If we can eat with rate k, save answer and try a smaller k
            if (canEat(mid, piles, h)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    // Check whether we can eat all bananas in h hours, with eating rate k
    private boolean canEat(int k, int[] piles, int h) {
        int numHours = 0;

        for (int pile : piles) {
            numHours += (int) Math.ceil(pile * 1.0 / k);
            if (numHours > h) {
                return false;
            }
        }

        return true;
    }
}
