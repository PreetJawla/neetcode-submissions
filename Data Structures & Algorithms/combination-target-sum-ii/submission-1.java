class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);  // Required to skip duplicates
        backTrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public void backTrack(int[] candidates, int target, int index, List<Integer> temp, List<List<Integer>> result){
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue; 

            if (candidates[i] > target) break;  

            temp.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i + 1, temp, result); 
            temp.remove(temp.size() - 1);
        }
    }
}
