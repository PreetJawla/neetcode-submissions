class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> newStack = new Stack<>();
        
        for (String token : tokens) {
            if (isNumeric(token)) { 
                newStack.push(Integer.parseInt(token));
            } else { 
                int b = newStack.pop();   
                int a = newStack.pop();  
                int ans = performOperation(a, b, token); 
                newStack.push(ans);
            }
        }
        return newStack.pop(); 
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int performOperation(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; 
            default: throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}
