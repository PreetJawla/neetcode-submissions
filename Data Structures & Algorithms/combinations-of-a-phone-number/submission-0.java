class Solution {
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        backTrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backTrack(String digits, int index, StringBuilder temp, List<String> result) {
        if (index == digits.length()) {
            result.add(temp.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = KEYPAD[digit];

        for (int i = 0; i < letters.length(); i++) {
            temp.append(letters.charAt(i));
            backTrack(digits, index + 1, temp, result);
            temp.deleteCharAt(temp.length() - 1); // backtrack
        }
    }
}
