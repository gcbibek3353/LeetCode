var combinationSum2 = function(candidates, target) {
    const ans = [];
    candidates.sort((a, b) => a - b); // Sort the candidates to handle duplicates
    getAllComb(candidates, 0, 0, []);

    function getAllComb(arr, i, curSum, curArr) {
        if (curSum === target) {
            ans.push([...curArr]);
            return;
        }
        if (i >= arr.length || curSum > target) {
            return;
        }

        // Include the current number
        curArr.push(arr[i]);
        getAllComb(arr, i + 1, curSum + arr[i], curArr);
        curArr.pop();

        // Skip duplicates
        while (i + 1 < arr.length && arr[i] === arr[i + 1]) {
            i++;
        }

        // Exclude the current number and move to the next unique number
        getAllComb(arr, i + 1, curSum, curArr);
    }

    return ans;
};