class Solution {
    public boolean isAnagram(String s, String t) {
        int[] chArray = new int[26];
        Arrays.fill(chArray, 0);

        for(char ch : s.toCharArray()){
            chArray[ch - 'a']++;
        }
        for(char ch : t.toCharArray()){
            chArray[ch - 'a']--;
        }
        for(int i : chArray)if(i != 0)return false;
        return true;

    }
}
