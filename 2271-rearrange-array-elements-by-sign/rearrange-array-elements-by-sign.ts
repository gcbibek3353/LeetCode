function rearrangeArray(nums: number[]): number[] {
    let result = new Array<number>();
    let evenIndex = 0; let oddIndex = 1;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] > 0) {
            result[evenIndex] = nums[i]
            evenIndex += 2;
        }
        else {
            result[oddIndex] = nums[i];
            oddIndex += 2;
        }
    }
    return result;
}
