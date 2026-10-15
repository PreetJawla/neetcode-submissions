class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] ch = s.toCharArray(), th = t.toCharArray();
        Arrays.sort(ch);
        Arrays.sort(th);
        String s1 = Arrays.toString(ch);
        String s2 = Arrays.toString(th);
        return Arrays.equals(ch, th);
    }
}
