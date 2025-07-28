function subsets(nums: number[]): number[][] {
    let ans = [];
    let curArr = [];

    const dfs = (count: number): void => {
        if (count === nums.length) {
            ans.push([...curArr]);
            return;
        }
        curArr.push(nums[count]);
        dfs(count + 1);
        curArr.pop();
        dfs(count + 1);
    }
    dfs(0);
    return ans;
};