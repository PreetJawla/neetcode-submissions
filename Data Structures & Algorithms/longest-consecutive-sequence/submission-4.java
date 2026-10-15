class Solution {
    public int longestConsecutive(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;

        Arrays.sort(nums);
        int l = 0, r = 0, maxLength = 1;

        while (r + 1 < length) {
            if (nums[r + 1] == nums[r] + 1) {
                r++;
                maxLength = Math.max(maxLength, r - l + 1);
            } else if (nums[r] == nums[r + 1]) {
                r++;
                l++; 
            } else {
                r++;
                l = r;  
            }
        }
        return maxLength;
    }
}
