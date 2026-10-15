class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!freqMap.containsKey(c)) return false;

            int count = freqMap.get(c);
            if (count == 1) {
                freqMap.remove(c);
            } else {
                freqMap.put(c, count - 1);
            }
        }

        return freqMap.isEmpty();
    }
}
