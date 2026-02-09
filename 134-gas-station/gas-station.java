class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int totalGas = 0;
        int totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        // Global feasibility check
        if (totalGas < totalCost) return -1;
        
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];

            if (tank < 0) {
                // Can't start from start ... i
                tank = 0;
                start = i + 1;
            }
        }

        return start;
    }
}