function combinationSum(candidates: number[], target: number): number[][] {
    const ans: number[][] = [];

    function findCombination(index: number, arr: number[], sum: number) {
        // Base case: if the sum equals the target, add the combination to the result
        if (sum === target) {
            ans.push([...arr]);
            return;
        }

        // Base case: if the sum exceeds the target or index goes out of bounds, stop
        if (sum > target || index >= candidates.length) {
            return;
        }

        // Include the current candidate (can be used multiple times)
        arr.push(candidates[index]);
        sum += candidates[index];
        findCombination(index, arr, sum );
        sum -= candidates[index]; // Recurse with the same index
        arr.pop();

        // Exclude the current candidate and move to the next
        findCombination(index + 1, arr, sum);
    }

    findCombination(0, [], 0);
    return ans;
}
