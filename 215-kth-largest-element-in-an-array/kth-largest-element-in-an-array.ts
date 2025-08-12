// ---------- MaxHeap implementation ----------
class MaxHeap {
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
            if (this.heap[idx] > this.heap[parent]) {
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
            let largest = idx;

            if (left < length && this.heap[left] > this.heap[largest]) {
                largest = left;
            }
            if (right < length && this.heap[right] > this.heap[largest]) {
                largest = right;
            }
            if (largest !== idx) {
                this.swap(idx, largest);
                idx = largest;
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

    size(): number {
        return this.heap.length;
    }
}

// using maxHeap to store all the elements and removing k elements from the top.
function findKthLargest(nums: number[], k: number): number {
     const maxHeap = new MaxHeap();
    for (let num of nums) {
        maxHeap.push(num); // O(log n)
    }
    let result = 0;
    for (let i = 0; i < k; i++) { // O(k log n)
        result = maxHeap.pop()!;
    }
    return result;
};