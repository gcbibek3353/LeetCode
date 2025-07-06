class FindSumPairs {
    private nums1: number[];
    private nums2: number[];
    private freqMap: Map<number, number>;

    constructor(nums1: number[], nums2: number[]) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freqMap = new Map();

        for (const num of nums2) {
            this.freqMap.set(num, (this.freqMap.get(num) || 0) + 1);
        }
    }

    add(index: number, val: number): void {
        const oldVal = this.nums2[index];
        const newVal = oldVal + val;
        this.nums2[index] = newVal;

        // Update frequency map
        this.freqMap.set(oldVal, this.freqMap.get(oldVal)! - 1);
        if (this.freqMap.get(oldVal) === 0) this.freqMap.delete(oldVal);

        this.freqMap.set(newVal, (this.freqMap.get(newVal) || 0) + 1);
    }

    count(tot: number): number {
        let count = 0;
        for (const num1 of this.nums1) {
            const complement = tot - num1;
            count += this.freqMap.get(complement) || 0;
        }
        return count;
    }
}
