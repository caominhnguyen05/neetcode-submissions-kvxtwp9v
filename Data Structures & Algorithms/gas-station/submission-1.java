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

        if (sumCost > sumGas) {
            return -1;
        }

        int startPos = 0;
        int currGas = 0;

        for (int i = 0; i < gas.length; i++) {
            currGas += gas[i] - cost[i];
            if (currGas < 0) {
                currGas = 0;
                startPos = i + 1;
            } 
        }

        return startPos;
    }
}
