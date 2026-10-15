class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backTrack(s, result, new ArrayList<>(), 0);
        return result;
    }

    public void backTrack(String s, List<List<String>> result, List<String> temp, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(temp)); 
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (checkPalindrome(sub)) {
                temp.add(sub); 
                backTrack(s, result, temp, i + 1); 
                temp.remove(temp.size() - 1); 
            }
        }
    }

    public boolean checkPalindrome(String str) {
        int leftPtr = 0, rightPtr = str.length() - 1;
        while (leftPtr < rightPtr) {
            if (str.charAt(leftPtr) != str.charAt(rightPtr)) return false;
            leftPtr++;
            rightPtr--;
        }
        return true;
    }
}
