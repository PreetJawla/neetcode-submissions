class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] ch = s.toCharArray(), th = t.toCharArray();
        Arrays.sort(ch);
        Arrays.sort(th);
        return Arrays.equals(ch, th);
    }
}
