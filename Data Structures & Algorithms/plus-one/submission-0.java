class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        int carry = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                digits[i] = (digits[i] + 1) % 10;
                if (digits[i] == 0) {
                    carry = 1;
                }
            } else {
                int temp = digits[i] + carry;
                digits[i] = temp % 10;
                carry = temp / 10;
            }
        }

        if (carry == 1) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        } else {
            return digits;
        }
    }
}
