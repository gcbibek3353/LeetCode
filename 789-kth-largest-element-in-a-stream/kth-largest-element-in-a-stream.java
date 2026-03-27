class KthLargest {
    List<Integer> scores;
    int k;
    public KthLargest(int k, int[] nums) {
        this.scores = new ArrayList<>();
        this.k = k;
        for(int num : nums){
            scores.add(num);
        }
        Collections.sort(scores);
    }
    
    public int add(int val) {
        int index = findIndex( val);
        scores.add(index , val);
        return scores.get(scores.size() - k);
    }

    private int findIndex(int val) {
        int l = 0;
        int r = scores.size() - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(scores.get(m) == val) return m;
            else if(scores.get(m) < val) l = m + 1;
            else r = m - 1;
        }
        return l;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */