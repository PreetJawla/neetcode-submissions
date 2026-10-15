class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int[] stringFirst = new int[26];
        int[] window = new int[26];
        for(char c: s1.toCharArray()){
            stringFirst[c - 'a']++;
        }
        int windowSize = s1.length();
        for(int i = 0 ; i < windowSize; i++){
            window[ s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(stringFirst, window)) return true;

        for(int i = windowSize; i < s2.length(); i++){
            int newChar = s2.charAt(i);
            int oldChar = s2.charAt(i - windowSize );
            window[newChar - 'a']++;
            window[oldChar - 'a']--;
            if(Arrays.equals(stringFirst, window)) return true;
        }

        return false;   
    }
}


