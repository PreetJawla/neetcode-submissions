
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int maxLength = 1;
        int gLeft = 0, gRight = 1;

        for (int i = 0; i < s.length(); i++) {

            int left = i, right = i;

            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            if (right - left - 1 > maxLength) {
                maxLength = right - left - 1;
                gLeft = left + 1;
                gRight = right;
            }


            left = i;
            right = i + 1;

            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            if (right - left - 1 > maxLength) {
                maxLength = right - left - 1;
                gLeft = left + 1;
                gRight = right;
            }
        }

        return s.substring(gLeft, gRight);
    }
}
