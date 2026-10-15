class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length < k) return -1;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums) maxHeap.add(i);
        while(k > 1){
            maxHeap.poll();
            k--;
        }
        return maxHeap.poll();
    }
}
