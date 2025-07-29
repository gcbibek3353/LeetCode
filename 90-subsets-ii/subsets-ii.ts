function subsetsWithDup(nums: number[]): number[][] {
    const ans: number[][] = [];
    const ds: number[] = [];

    function findSubsets(ind: number): void {
        ans.push([...ds]);
        for (let i = ind; i < nums.length; i++) {
            if (i !== ind && nums[i] === nums[i - 1]) {
                continue;
            }
            ds.push(nums[i]);
            findSubsets(i + 1);
            ds.pop();
        }
    }

    nums.sort((a, b) => a - b); // Sort to handle duplicates
    findSubsets(0);
    return ans;
}
