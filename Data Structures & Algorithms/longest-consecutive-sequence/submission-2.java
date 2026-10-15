class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0; 

        Arrays.sort(nums);
        int maxLength = 1, currentLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;  // Skip duplicates

            if (nums[i] == nums[i - 1] + 1) {
                currentLength++; 
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1; 
            }
        }
        
        return Math.max(maxLength, currentLength);  
    }
}
