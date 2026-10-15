class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> temp = new HashMap<>();

        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String temp2 = new String(arr);
            if(temp.containsKey(temp2)){
                temp.get(temp2).add(s);
            }else{
                temp.put(temp2, new ArrayList<>(Arrays.asList(s)));
            }
        }
        return new ArrayList<>(temp.values());
    }
}
