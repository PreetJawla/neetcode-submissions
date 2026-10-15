class Solution {
    public int singleNumber(int[] nums) {
        int xorSum = 0;
        for(int i : nums) xorSum ^= i;
        return xorSum;
    }
}
