function longestConsecutive(nums: number[]): number {
    let st = new Set(nums);
    let maxCount = 0;

    for (let num of st) {
        // Start of a sequence
        if (!st.has(num - 1)) {
            let curNum = num;
            let curCount = 1;

            while (st.has(curNum + 1)) {
                curNum++;
                curCount++;
            }

            maxCount = Math.max(maxCount, curCount);
        }
    }

    return maxCount;
}
