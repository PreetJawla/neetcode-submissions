class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> anaList = new HashMap<>();

        for (String s : strs) {
            char[] sortedArray = s.toCharArray();
            Arrays.sort(sortedArray);
            String key = new String(sortedArray);

            if (anaList.containsKey(key)) {
                anaList.get(key).add(s);
            } else {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(s);
                anaList.put(key, newList);
            }
        }

        List<List<String>> return_List = new ArrayList<>();
        for (String key : anaList.keySet()) {
            return_List.add(anaList.get(key));
        }
        return return_List;
    }
}
