class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = nums[0]+1;
        for(int i = 1; i < nums.length; i++){
            if(maxReach < i+1) return false;
            maxReach = Math.max(maxReach , i+1+nums[i]);
        }
        return true;
    }
}