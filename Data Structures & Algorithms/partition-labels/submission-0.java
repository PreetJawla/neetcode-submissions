class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> answer = new ArrayList<>();

        int[] lastIndex = new int[26];
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }

        int maxSoFar = 0;
        int startIdx = 0;

        for (int currIdx = 0; currIdx < chars.length; currIdx++) {
            maxSoFar = Math.max(maxSoFar, lastIndex[chars[currIdx] - 'a']);

            if (currIdx == maxSoFar) {
                answer.add(currIdx - startIdx + 1);
                startIdx = currIdx + 1;
            }
        }

        return answer;
    }
}
