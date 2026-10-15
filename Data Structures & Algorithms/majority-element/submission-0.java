class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0], frequency = 1;
        for( int i = 1; i < nums.length; i++){
            if(nums[i] == majority) frequency++;
            else{
                frequency -= 1;
                if(frequency == 0){
                    majority = nums[i];
                    frequency = 1;
                }
            }
        }
        return majority;
    }
}