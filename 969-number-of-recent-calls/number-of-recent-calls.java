class RecentCounter {
    ArrayList<Integer> ds;
    public RecentCounter() {
        ds = new ArrayList<>();
    }
    
    public int ping(int t) {
        ds.add(t);
        int index = ds.size() - 1;
        int count = 0;
        int thresholdTime = t - 3000;
        while(index >= 0){
            if(ds.get(index) >= thresholdTime) count ++;
            else break;
            index --;
        }
        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */