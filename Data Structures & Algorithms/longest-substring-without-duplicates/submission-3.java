class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestSize = 0;
        int l = 0;
        HashSet<Character> longestString = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(longestString.add(s.charAt(i))){
                longestSize = Math.max(longestSize, longestString.size());
            }else{
                while(l< i && longestString.contains(s.charAt(i))){
                    longestString.remove(s.charAt(l));
                    l++;
                }
                longestString.add(s.charAt(i));
            }
        }
        return longestSize;
    }
}
