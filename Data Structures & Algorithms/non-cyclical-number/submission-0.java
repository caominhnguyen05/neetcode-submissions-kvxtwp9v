class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        int sum = sumSquareDigits(n);

        while (sum != 1) {
            if (seen.contains(sum)) {
                return false;
            }

            seen.add(sum);
            sum = sumSquareDigits(sum);
        }

        return true;
    }

    private int sumSquareDigits(int n) {
        int sum = 0;

        while (n != 0) {
            int lastDigit = n % 10;
            sum += lastDigit * lastDigit;
            n /= 10;
        }

        return sum;
    }
}
