class SmallestInfiniteSet {
    int naturallySmallest;
    Queue<Integer> minHeap;
    Set<Integer> st;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        st = new HashSet<>();
        this.naturallySmallest = 1;
    }

    public int popSmallest() {
        if(!minHeap.isEmpty()){
            int minValue = minHeap.poll();
            st.remove(minValue);
            return minValue;
        }
        return naturallySmallest ++;
    }

    public void addBack(int num) {
        if(num >= naturallySmallest || st.contains(num)) return;
        minHeap.offer(num);
        st.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */