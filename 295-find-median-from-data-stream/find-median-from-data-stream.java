import java.util.*;

class MedianFinder {

    private PriorityQueue<Integer> maxHeap; // left (smaller half)
    private PriorityQueue<Integer> minHeap; // right (larger half)

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step 1: add to maxHeap
        maxHeap.offer(num);
        
        // Step 2: balance order
        minHeap.offer(maxHeap.poll());
        
        // Step 3: balance size
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}