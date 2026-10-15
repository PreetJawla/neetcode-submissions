class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums)set.add(i);

        int maxCon = 0;
        for(int i : nums){
            if(!set.contains(i-1)){
                int currLen = 1;
                while(set.contains(i+currLen)){
                    currLen++;
                }
                maxCon = Math.max(maxCon, currLen);
            }
        }
        return maxCon;
    }
}
