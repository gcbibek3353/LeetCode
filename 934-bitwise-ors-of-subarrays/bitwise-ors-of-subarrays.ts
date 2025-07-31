function subarrayBitwiseORs(arr: number[]): number {
    const res = new Set<number>();
    let prev = new Set<number>();

    for (const num of arr) {
        const curr = new Set<number>();

        // Extend all previous ORs with the current number
        for (const val of prev) {
            curr.add(val | num);
        }

        // Also include the subarray of just the current number
        curr.add(num);

        // Add all current OR results to the result set
        for (const val of curr) {
            res.add(val);
        }

        // Update prev to curr for the next round
        prev = curr;
    }

    return res.size;
}
