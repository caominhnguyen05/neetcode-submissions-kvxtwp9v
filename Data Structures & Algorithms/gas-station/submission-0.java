class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        for (int num : gas) {
            sumGas += num;
        }

        int sumCost = 0;
        for (int num : cost) {
            sumCost += num;
        }

        if (sumGas < sumCost) {
            return -1;
        }

        int currTotal = 0;
        int resIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            currTotal += gas[i] - cost[i];
            if (currTotal < 0) {
                currTotal = 0;
                resIndex = i + 1;
            }
        }

        return resIndex;
        
    }
}
