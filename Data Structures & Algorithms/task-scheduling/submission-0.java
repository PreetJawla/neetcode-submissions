class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqArr = new int[26];

        for(char c : tasks){
            freqArr[c - 'A']++;
        }

        int maxFreq = 0;
        for(int i : freqArr) maxFreq = Math.max(maxFreq, i);

        
        int maxFreqCount = 0;
        for(int i : freqArr){
            if(i == maxFreq) maxFreqCount++;
        }

        int totalJobs = Math.max(tasks.length, ((n+1) *(maxFreq- 1) + maxFreqCount));
        return totalJobs;
    }
}
// 