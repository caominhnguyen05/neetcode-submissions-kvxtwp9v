class Solution {
    public String multiply(String num1, String num2) {
        // Special case
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        int[] res = new int[m + n];

        // Multiply each digit pair (from right to left)
        for (int i = m - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';

            for (int j = n - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';

                int product = d1 * d2;

                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = product + res[p2];

                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        // Build answer, skipping leading zeros
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        while (idx < res.length && res[idx] == 0) {
            idx++;
        }

        while (idx < res.length) {
            sb.append(res[idx]);
            idx++;
        }

        return sb.toString();
    }
}
