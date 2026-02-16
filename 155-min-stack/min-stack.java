class MinStack {
    ArrayDeque<int[]> primaryStack;

    public MinStack() {
        this.primaryStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        int minValue = val;
        if(!primaryStack.isEmpty()){
            int[] topElm = primaryStack.peek();
            minValue = Math.min(minValue , topElm[1]);
        }
        int[] curElm = new int[]{val,minValue};
        primaryStack.push(curElm);
    }
    
    public void pop() {
        if(!primaryStack.isEmpty()) primaryStack.pop();
    }
    
    public int top() {
        return primaryStack.peek()[0];
    }
    
    public int getMin() {
        return primaryStack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */