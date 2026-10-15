class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length, totalGas = 0, totalCost  = 0;
        int[] gasConsumption = new int[length];
        for(int i = 0; i < length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
            gasConsumption[i] = gas[i] - cost[i];
        }

        if(totalCost > totalGas) return -1;


        int startIdx = 0;
        totalGas = gas[0] - cost[0];
        for(int i = 1; i< length; i++){
            if(totalGas < 0 || totalGas + gas[i] < 0){
                totalGas = gas[i] - cost[i];
                startIdx = i;
            }else{
                totalGas += (gas[i] - cost[i]);
            } 
        }

        return startIdx;
    }
}