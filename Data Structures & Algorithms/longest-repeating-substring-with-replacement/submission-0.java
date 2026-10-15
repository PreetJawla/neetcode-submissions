class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqArr = new int[26];
 
        int left = 0, maxSize = 0, maxFreq = 0;

        for(int right = 0; right < s.length(); right++){
            freqArr[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freqArr[s.charAt(right) - 'A']);

            int windowSize = right - left + 1;
            if(windowSize - maxFreq > k){
                freqArr[s.charAt(left) - 'A']--;
                left++;
            }else{
                maxSize = Math.max(maxSize, windowSize);
            }
        }
        return maxSize;
    }
}