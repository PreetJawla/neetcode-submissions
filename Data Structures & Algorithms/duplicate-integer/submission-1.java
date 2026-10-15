class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer,Integer> freMap = new HashMap<>();
        int a = 0;
        for(int i : nums){
            if(freMap.containsKey(i)) return true;
            freMap.put(i,a);
        }
        return false;
    }
}
