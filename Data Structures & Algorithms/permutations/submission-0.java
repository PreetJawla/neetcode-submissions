class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int[] vis = new int[nums.length];  // ✅ Correct size
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, vis, result, new ArrayList<Integer>());
        return result;
    }

    public void backTrack(int[] nums, int[] vis, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() == nums.length) {  
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i] != 0) continue; 

            temp.add(nums[i]);
            vis[i] = 1;

            backTrack(nums, vis, result, temp);

            vis[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }
}
