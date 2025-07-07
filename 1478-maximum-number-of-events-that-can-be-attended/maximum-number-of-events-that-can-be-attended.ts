function maxEvents(events: number[][]): number {
    events.sort((a, b) => a[0] - b[0]);

    const minHeap: number[] = [];
    let eventIndex = 0;
    let count = 0;
    let currentDay = 1;
    const n = events.length;

    const pushHeap = (heap: number[], value: number) => {
        heap.push(value);
        let index = heap.length - 1;
        while (index > 0) {
            const parentIndex = Math.floor((index - 1) / 2);
            if (heap[parentIndex] <= heap[index]) break;
            [heap[parentIndex], heap[index]] = [heap[index], heap[parentIndex]];
            index = parentIndex;
        }
    };

    const popHeap = (heap: number[]): number | undefined => {
        if (heap.length === 0) return undefined;
        const top = heap[0];
        const last = heap.pop()!;
        if (heap.length > 0) {
            heap[0] = last;
            let index = 0;
            while (true) {
                const leftIndex = 2 * index + 1;
                const rightIndex = 2 * index + 2;
                let smallestIndex = index;

                if (leftIndex < heap.length && heap[leftIndex] < heap[smallestIndex]) {
                    smallestIndex = leftIndex;
                }
                if (rightIndex < heap.length && heap[rightIndex] < heap[smallestIndex]) {
                    smallestIndex = rightIndex;
                }
                if (smallestIndex === index) break;
                [heap[index], heap[smallestIndex]] = [heap[smallestIndex], heap[index]];
                index = smallestIndex;
            }
        }
        return top;
    };

    while (eventIndex < n || minHeap.length > 0) {
        while (eventIndex < n && events[eventIndex][0] === currentDay) {
            pushHeap(minHeap, events[eventIndex][1]);
            eventIndex++;
        }

        while (minHeap.length > 0 && minHeap[0] < currentDay) {
            popHeap(minHeap);
        }

        if (minHeap.length > 0) {
            popHeap(minHeap);
            count++;
        }

        currentDay++;
    }

    return count;
}