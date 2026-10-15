class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> returnList = new ArrayList<>();
        backTrack(nums, target, returnList, new ArrayList<>(), 0, 0);
        return returnList;
    }

    public void backTrack(int[] nums, int target, List<List<Integer>> returnList, List<Integer> temp, int index, int currSum){
        if(currSum == target){
            returnList.add(new ArrayList<>(temp));
        }
        if(currSum > target){
            return;
        }
        for(int i = index; i < nums.length; i++){
            temp.add(nums[i]);
            currSum += nums[i];
            backTrack(nums, target, returnList, temp, i, currSum);
            currSum -= temp.get(temp.size()-1);
            temp.remove(temp.size()- 1);
        }
    }
}
