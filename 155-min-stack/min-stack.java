class MinStack {
    List<int[]> list;

    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int val) {
        if (list.isEmpty()) {
            int[] elm = new int[] { val, val };
            list.add(elm);
        } else {
            int[] elm = list.get(list.size() - 1);
            int min = Math.min(val, elm[1]);
            int[] elm1 = new int[] { val, min };
            list.add(elm1);
        }
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.isEmpty() ? -1 :list.get(list.size() - 1)[0];
    }

    public int getMin() {
        return list.isEmpty() ? -1 :list.get(list.size() - 1)[1];
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