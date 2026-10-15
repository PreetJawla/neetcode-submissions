class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        int[] arr = new int[n];
        Stack<Character> stc = new Stack<>();
        for(int i = 0; i < n; i++){
             if(stc.isEmpty()) stc.push(s.charAt(i));
             else{
                if(s.charAt(i) == ')' && stc.peek() == '(' || s.charAt(i) == '}' && stc.peek() == '{' ||s.charAt(i) == ']' && stc.peek() == '[') stc.pop();
                else{
                    stc.push(s.charAt(i));
                }
             }
        }
        if(stc.isEmpty()) return true;
        return false;
    }
}
