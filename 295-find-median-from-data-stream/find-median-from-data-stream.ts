class MinHeap {
    heap: number[];

    constructor() {
        this.heap = [];
    }

    size(): number {
        return this.heap.length;
    }

    top(): number {
        return this.heap[0];
    }

    push(val: number): void {
        this.heap.push(val);
        this.bubbleUp(this.heap.length - 1);
    }

    pop(): number {
        if (this.size() === 0) return null;
        const root = this.heap[0];
        const end = this.heap.pop();
        if (this.size() > 0) {
            this.heap[0] = end;
            this.bubbleDown(0);
        }
        return root;
    }

    private bubbleUp(index: number) {
        while (index > 0) {
            const parent = Math.floor((index - 1) / 2);
            if (this.heap[index] >= this.heap[parent]) break;
            [this.heap[index], this.heap[parent]] = [this.heap[parent], this.heap[index]];
            index = parent;
        }
    }

    private bubbleDown(index: number) {
        const length = this.size();
        while (true) {
            let left = index * 2 + 1;
            let right = index * 2 + 2;
            let smallest = index;

            if (left < length && this.heap[left] < this.heap[smallest]) {
                smallest = left;
            }
            if (right < length && this.heap[right] < this.heap[smallest]) {
                smallest = right;
            }
            if (smallest === index) break;
            [this.heap[index], this.heap[smallest]] = [this.heap[smallest], this.heap[index]];
            index = smallest;
        }
    }
}

class MaxHeap {
    heap: number[];

    constructor() {
        this.heap = [];
    }

    size(): number {
        return this.heap.length;
    }

    top(): number {
        return this.heap[0];
    }

    push(val: number): void {
        this.heap.push(val);
        this.bubbleUp(this.heap.length - 1);
    }

    pop(): number {
        if (this.size() === 0) return null;
        const root = this.heap[0];
        const end = this.heap.pop();
        if (this.size() > 0) {
            this.heap[0] = end;
            this.bubbleDown(0);
        }
        return root;
    }

    private bubbleUp(index: number) {
        while (index > 0) {
            const parent = Math.floor((index - 1) / 2);
            if (this.heap[index] <= this.heap[parent]) break;
            [this.heap[index], this.heap[parent]] = [this.heap[parent], this.heap[index]];
            index = parent;
        }
    }

    private bubbleDown(index: number) {
        const length = this.size();
        while (true) {
            let left = index * 2 + 1;
            let right = index * 2 + 2;
            let largest = index;

            if (left < length && this.heap[left] > this.heap[largest]) {
                largest = left;
            }
            if (right < length && this.heap[right] > this.heap[largest]) {
                largest = right;
            }
            if (largest === index) break;
            [this.heap[index], this.heap[largest]] = [this.heap[largest], this.heap[index]];
            index = largest;
        }
    }
}

class MedianFinder {
    minhp: MinHeap;
    maxhp: MaxHeap;

    constructor() {
        this.minhp = new MinHeap(); // larger half
        this.maxhp = new MaxHeap(); // smaller half
    }

    addNum(num: number): void {
        if (this.maxhp.size() === 0 || num <= this.maxhp.top()) {
            this.maxhp.push(num);
        } else {
            this.minhp.push(num);
        }

        // Balance heaps
        if (this.maxhp.size() > this.minhp.size() + 1) {
            this.minhp.push(this.maxhp.pop());
        } else if (this.minhp.size() > this.maxhp.size()) {
            this.maxhp.push(this.minhp.pop());
        }
    }

    findMedian(): number {
        if (this.maxhp.size() === this.minhp.size()) {
            return (this.maxhp.top() + this.minhp.top()) / 2;
        } else {
            return this.maxhp.top();
        }
    }
}

// Example usage:
const mf = new MedianFinder();
mf.addNum(1);
mf.addNum(2);
console.log(mf.findMedian()); // 1.5
mf.addNum(3);
console.log(mf.findMedian()); // 2
