// ---------- MaxHeap for [char, freq] ----------
class MaxHeap {
    private heap: [string, number][];

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
            if (this.heap[idx][1] > this.heap[parent][1]) {
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

            if (left < length && this.heap[left][1] > this.heap[largest][1]) {
                largest = left;
            }
            if (right < length && this.heap[right][1] > this.heap[largest][1]) {
                largest = right;
            }
            if (largest !== idx) {
                this.swap(idx, largest);
                idx = largest;
            } else break;
        }
    }

    push(val: [string, number]) {
        this.heap.push(val);
        this.bubbleUp();
    }

    pop(): [string, number] | undefined {
        if (this.heap.length === 0) return undefined;
        const top = this.heap[0];
        const end = this.heap.pop();
        if (this.heap.length > 0 && end) {
            this.heap[0] = end;
            this.bubbleDown();
        }
        return top;
    }

    size(): number {
        return this.heap.length;
    }
}

// ---------- Main Function ----------
function reorganizeString(s: string): string {
    const freqMap = new Map<string, number>();

    // Count frequencies
    for (let char of s) {
        freqMap.set(char, (freqMap.get(char) || 0) + 1);
    }

    const maxHeap = new MaxHeap();

    // Push all chars with frequency
    for (let [char, freq] of freqMap) {
        maxHeap.push([char, freq]);
    }

    let result = "";

    while (maxHeap.size() > 1) {
        const first = maxHeap.pop()!;
        const second = maxHeap.pop()!;

        // Append two different chars
        result += first[0];
        result += second[0];

        if (--first[1] > 0) maxHeap.push(first);
        if (--second[1] > 0) maxHeap.push(second);
    }

    // If one char remains
    if (maxHeap.size() === 1) {
        const last = maxHeap.pop()!;
        if (last[1] > 1) return ""; // impossible
        result += last[0];
    }

    return result;
}

// ---------- Examples ----------
console.log(reorganizeString("aab"));   // "aba"
console.log(reorganizeString("aaab"));  // ""
console.log(reorganizeString("aaabc")); // possible result like "abaca"
