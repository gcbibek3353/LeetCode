class MinHeap {
    private heap: number[];

    constructor() {
        this.heap = [];
    }

    private swap(i: number, j: number) {
        [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
    }

    private bubbleUp() {
        let idx = this.heap.length - 1;
        while (idx > 0) {
            const parent = Math.floor((idx - 1) / 2);
            if (this.heap[idx] < this.heap[parent]) {
                this.swap(idx, parent);
                idx = parent;
            } else break;
        }
    }

    private bubbleDown() {
        let idx = 0;
        const length = this.heap.length;
        while (true) {
            let left = 2 * idx + 1;
            let right = 2 * idx + 2;
            let smallest = idx;

            if (left < length && this.heap[left] < this.heap[smallest]) {
                smallest = left;
            }
            if (right < length && this.heap[right] < this.heap[smallest]) {
                smallest = right;
            }
            if (smallest !== idx) {
                this.swap(idx, smallest);
                idx = smallest;
            } else break;
        }
    }

    push(val: number) {
        this.heap.push(val);
        this.bubbleUp();
    }

    pop(): number | undefined {
        if (this.heap.length === 0) return undefined;
        const top = this.heap[0];
        const end = this.heap.pop();
        if (this.heap.length > 0 && end !== undefined) {
            this.heap[0] = end;
            this.bubbleDown();
        }
        return top;
    }

    peek(): number {
        return this.heap[0];
    }

    size(): number {
        return this.heap.length;
    }
}

// using minHeap of size k to store largest 'k' elements of array .
function findKthLargest(nums: number[], k: number): number {
      const minHeap = new MinHeap();

    for (let num of nums) {
        minHeap.push(num);
        if (minHeap.size() > k) {
            minHeap.pop(); // keep heap size <= k
        }
    }

    return minHeap.peek();
};