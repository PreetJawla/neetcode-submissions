class Solution {
    int[] dp;
    public int rob(int[] nums) {
        if(nums.length == 1)return nums[0];
        if(nums.length == 2)return Math.max(nums[0], nums[1]);

        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int firstTaken = nums[0] + dp(nums, 2, nums.length -2);

        Arrays.fill(dp, -1);
        int fNotTaken = dp(nums, 1, nums.length - 1);

        return Math.max(firstTaken, fNotTaken);
    }

    public int dp(int[] nums, int index, int end){
        if(index > end)return 0;

        if(dp[index] != -1)return dp[index];


        int currTaken = nums[index] + dp(nums, index+2, end);

        int nextTaken = dp(nums, index+1, end);

        dp[index] = Math.max(currTaken, nextTaken);

        return dp[index];
    }
}
