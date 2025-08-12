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

function minRefuelStops(target: number, startFuel: number, stations: number[][]): number {
    const pq = new MaxHeap();
    let fuelLeft = startFuel;
    let stops = 0;
    let prevPosition = 0;

    for (let station of stations) {
        fuelLeft -= (station[0] - prevPosition);
        while (fuelLeft < 0) {
            if (pq.size() <= 0) return -1;
            fuelLeft += pq.pop();
            stops++;
        }
        pq.push(station[1]);
        prevPosition = station[0];
    }

    fuelLeft -= (target - prevPosition);
    while (fuelLeft < 0) {
        if (pq.size() <= 0) return -1;
        fuelLeft += pq.pop();
        stops++;
    }
    return stops;
};