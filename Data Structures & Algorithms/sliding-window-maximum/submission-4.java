class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (k > n || k == 0) return new int[]{};

        int[] result = new int[n - k + 1];

        int l = 0, r = 0;
        int currMax = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            currMax = Math.max(currMax, nums[i]);
            r++;
        }

        result[0] = currMax;
        int idx = 1;

        while (r < n) {
            // If the leftmost element was the max and is going out, recalculate max
            if (nums[l] == currMax) {
                currMax = nums[l + 1];
                for (int i = l + 1; i <= r; i++) {
                    currMax = Math.max(currMax, nums[i]);
                }
            } else {
                currMax = Math.max(currMax, nums[r]);
            }

            result[idx++] = currMax;
            l++;
            r++;
        }

        return result;
    }
}