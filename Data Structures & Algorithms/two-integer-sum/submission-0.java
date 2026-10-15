class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) return new int[0];

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];

            if (freqMap.containsKey(rem)) {
                return new int[] {freqMap.get(rem), i};
            }

            freqMap.put(nums[i], i);
        }

        return new int[0];
    }
}
