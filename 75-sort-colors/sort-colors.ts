/**
 Do not return anything, modify nums in-place instead.
 */
function sortColors(nums: number[]): void {
    let zeroCount = 0;
    let oneCount = 0;
    let twoCount = 0;

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === 0) zeroCount++;
        else if (nums[i] === 1) oneCount++;
        else twoCount++;
    }
    let i = 0;
    while (i <= zeroCount - 1) nums[i++] = 0;
    while (i <= zeroCount + oneCount - 1) nums[i++] = 1;
    while (i <= zeroCount + oneCount + twoCount - 1) nums[i++] = 2;

};