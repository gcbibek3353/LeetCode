class MinStack {

    class Node{
        int value;
        int minTillNow;
        public Node(int val , int min){
            value = val;
            minTillNow = min;
        }
    }
    List<Node> ds;

    public MinStack() {
        ds = new ArrayList<>();
    }
    
    public void push(int value) {
        int min = value;
        if(ds.size() > 0){
            Node lastNode = ds.get(ds.size() - 1);
            min = lastNode.minTillNow;
        }
        min = Math.min(min , value);
        Node newNode = new Node(value , min);
        ds.add(newNode); 
    }
    
    public void pop() {
        ds.remove(ds.size() - 1);
    }
    
    public int top() {
        return ds.get(ds.size() - 1).value;
    }
    
    public int getMin() {
        return ds.get(ds.size() - 1).minTillNow;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */