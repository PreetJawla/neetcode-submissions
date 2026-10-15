class Solution {
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        if(length == 1 ) return 0;
        Arrays.sort(nums);
        int toReturn;
        int curr = nums[0];
        for(int i = 1; i < length; i++){
            if(curr == nums[i]) return curr;
            else{
                curr = nums[i];
            }
        }
        return 0;
    }
}