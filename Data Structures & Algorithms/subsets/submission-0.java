class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<Integer>() , 0, nums);
        return result;
    }
    public void backTrack(List<List<Integer>> result, ArrayList<Integer> temp, int index, int[] arr){
        result.add(new ArrayList<Integer>(temp));
        for(int i = index; i < arr.length; i++){
           temp.add(arr[i]);
           backTrack(result, temp, i+1, arr);
           temp.remove(temp.size()-1); 
        }
    }
}
