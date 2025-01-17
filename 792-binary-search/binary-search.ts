function search(nums: number[], target: number): number {
    let startIndex = 0;
    let endIndex = nums.length - 1;

    while (startIndex <= endIndex) {
        const middleIndex = Math.floor((startIndex + endIndex) / 2);
        const middleValue = nums[middleIndex];

        if (middleValue === target) {
            return middleIndex;
        }
        else if (middleValue < target) {
            startIndex = middleIndex + 1;
        } else {
            endIndex = middleIndex - 1;
        }
    }

    return -1;
}