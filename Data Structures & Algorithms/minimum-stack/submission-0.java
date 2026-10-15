class MinStack {
    LinkedList<Integer> newStack;
    public MinStack() {
        newStack = new LinkedList<>();
    }
    
    public void push(int val) {
        newStack.addLast(val);
   
    }
    
    public void pop() {
        newStack.removeLast();
    }
    
    public int top() {
        int remove = newStack.removeLast();
        push(remove);
        return remove;
    }
    
    public int getMin() {
        int min = newStack.getFirst();
        for(int i : newStack){
            if(min > i) min = i;
        }
        return min;
    }
}
