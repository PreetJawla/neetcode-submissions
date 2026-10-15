class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        backTrack(returnList, nums, 0, new ArrayList<>());
        return returnList;
    }

    public void backTrack(List<List<Integer>> returnList, int[] nums, int index, List<Integer> temp){
        returnList.add(new ArrayList<>(temp));

        for(int i = index; i < nums.length; i++){
            temp.add(nums[i]);
            backTrack(returnList,nums, i+1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
