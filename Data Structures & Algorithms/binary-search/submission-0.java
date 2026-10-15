class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (nums.length - 1)/2;
        while(left <= right){
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target){
                left = mid + 1;
                mid = (right + left)/2;                

            }else{
                right = mid-1;
                mid = mid/2;
            }
        }
        return -1;
    }
}
