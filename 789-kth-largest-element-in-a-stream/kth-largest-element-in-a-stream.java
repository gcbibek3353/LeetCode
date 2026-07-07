class KthLargest {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        maxHeap = new PriorityQueue<>((a , b) -> b - a);
        minHeap = new PriorityQueue<>((a , b) -> a - b);
        this.k = k;
        for(int i = 0; i < nums.length; i ++) {
            minHeap.offer(nums[i]);
            if(minHeap.size() > k) maxHeap.offer(minHeap.poll());
        }
        // System.out.println(maxHeap.peek());
    }
    
    public int add(int val) {
        if(minHeap.size() < k) minHeap.offer(val);
        else if((minHeap.size() > 0 && val > minHeap.peek())){
            maxHeap.offer(minHeap.poll());
            minHeap.offer(val);
            // System.out.printf("value : %d , minHeapMin :L %d \n", val , minHeap.peek());
        }
        else maxHeap.offer(val);
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */