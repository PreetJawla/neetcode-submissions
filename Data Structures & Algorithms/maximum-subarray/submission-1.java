class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], curr = nums[0];
        int left = 0;
        for(int right = 1; right < nums.length; right++){
            curr = Math.max(curr, 0) + nums[right];
            maxSum = Math.max(maxSum, curr);       
        }
        return maxSum; 
    }
}
