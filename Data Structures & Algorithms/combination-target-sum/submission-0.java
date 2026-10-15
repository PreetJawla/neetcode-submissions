class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, target, result, new ArrayList<>(), 0, 0);
        return result;
    }

    public void backTrack(int[] nums, int target, List<List<Integer>> result, List<Integer> temp, int index, int currSum) {
        if (currSum == target) {
            result.add(new ArrayList<>(temp));
            return;
        } else if (currSum > target) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backTrack(nums, target, result, temp, i, currSum + nums[i]); // i (not i+1) allows reuse
            temp.remove(temp.size() - 1);
        }
    }
}
