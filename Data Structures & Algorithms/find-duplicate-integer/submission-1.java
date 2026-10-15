class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0 ; i < nums.length; i++){
            int value = Math.abs(nums[i]);
            if(nums[value] < 0){
                return value;
            }
            nums[value] = -nums[value];
        }
        return -1;
    }
}