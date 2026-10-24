class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return dfs(nums, 0);
    }
    public int dfs(int[] nums, int index){
        if(index >= nums.length)return 0;

        if(dp[index] != -1)return dp[index];
        
        int currTaken = nums[index] + dfs(nums, index+2);
        int notTaken = dfs(nums, index+1);

        dp[index] = Math.max(currTaken, notTaken);

        return dp[index];
    }
}
