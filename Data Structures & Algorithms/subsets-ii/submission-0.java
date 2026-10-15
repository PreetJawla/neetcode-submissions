class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        backTrack(nums, new ArrayList<Integer>(), resultList, 0);
        return resultList;
    }
    public void backTrack(int[] nums, List<Integer> tempList, List<List<Integer>> resultList, int index){
        if(!resultList.contains(tempList)){
            resultList.add(new ArrayList<>(tempList));
        }
        
        for(int i = index ; i < nums.length ; i++){
            tempList.add(nums[i]);
            backTrack(nums, tempList, resultList, i+1);
            tempList.remove(tempList.size() -1);
        }
    }
}
