class Solution {
    int totalWays = 0;
    public int climbStairs(int n) {
        recursive(0, n);
        return totalWays;
    }
    public void recursive(int currentStep, int n){
        if(currentStep > n) return;
        if(currentStep == n){
            totalWays++;
            return;
        }

        recursive(currentStep+1, n);
        recursive(currentStep+2, n);
    }
}
