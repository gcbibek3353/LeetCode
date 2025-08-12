/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

// Simple MinHeap implementation for ListNode
class MinHeap {
    private heap: ListNode[];

    constructor() {
        this.heap = [];
    }

    private swap(i: number, j: number) {
        [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
    }

    private compare(a: ListNode, b: ListNode) {
        return a.val - b.val;
    }

    push(node: ListNode) {
        this.heap.push(node);
        this.bubbleUp();
    }

    pop(): ListNode | undefined {
        if (this.heap.length === 0) return undefined;
        const top = this.heap[0];
        const end = this.heap.pop();
        if (this.heap.length > 0 && end) {
            this.heap[0] = end;
            this.bubbleDown();
        }
        return top;
    }

    size() {
        return this.heap.length;
    }

    private bubbleUp() {
        let index = this.heap.length - 1;
        while (index > 0) {
            const parentIndex = Math.floor((index - 1) / 2);
            if (this.compare(this.heap[index], this.heap[parentIndex]) < 0) {
                this.swap(index, parentIndex);
                index = parentIndex;
            } else break;
        }
    }

    private bubbleDown() {
        let index = 0;
        const length = this.heap.length;

        while (true) {
            let left = 2 * index + 1;
            let right = 2 * index + 2;
            let smallest = index;

            if (left < length && this.compare(this.heap[left], this.heap[smallest]) < 0) {
                smallest = left;
            }
            if (right < length && this.compare(this.heap[right], this.heap[smallest]) < 0) {
                smallest = right;
            }
            if (smallest !== index) {
                this.swap(index, smallest);
                index = smallest;
            } else break;
        }
    }
}

function mergeKLists(lists: Array<ListNode | null>): ListNode | null {
    const minHeap = new MinHeap();

    // Push the head of each list into the heap
    for (let node of lists) {
        if (node) minHeap.push(node);
    }

    const dummy = new ListNode(0);
    let current = dummy;

    // Process heap until it's empty
    while (minHeap.size() > 0) {
        const smallest = minHeap.pop();
        if (!smallest) break;

        current.next = smallest;
        current = current.next;

        if (smallest.next) {
            minHeap.push(smallest.next);
        }
    }

    return dummy.next;
}