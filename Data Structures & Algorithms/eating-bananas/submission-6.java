class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int res = right;

        while (left <= right) {
            int speed = left + (right - left) / 2;

            if (canFinish(piles, speed, h)) {
                res = speed;
                right = speed - 1;
            } else {
                left = speed + 1;
            }
        }

        return res;
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        int hours = 0;
        
        for (int pile : piles) {
            hours += (int) Math.ceil(pile * 1.0 / speed);
            if (hours > h) {
                return false;
            }
        }   

        return true;
    }
}
