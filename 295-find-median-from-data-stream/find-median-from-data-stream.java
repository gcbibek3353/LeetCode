class MedianFinder {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a , b) -> a - b);
        maxHeap = new PriorityQueue<>((a , b) -> b - a);
    }
    
    public void addNum(int num) {
        if(minHeap.size() == 0) minHeap.offer(num);
        else if(num >= minHeap.peek()) minHeap.offer(num);
        else maxHeap.offer(num);
        int minHeapSize = minHeap.size();
        int maxHeapSize = maxHeap.size();
        if(minHeapSize > maxHeapSize + 1) maxHeap.offer(minHeap.poll());
        else if (minHeapSize < maxHeapSize) minHeap.offer(maxHeap.poll());
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return ((double)minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        else return minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */