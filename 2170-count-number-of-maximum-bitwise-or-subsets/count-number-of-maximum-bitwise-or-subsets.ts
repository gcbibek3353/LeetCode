function countMaxOrSubsets(nums: number[]): number {
    let count: number = 0;
    let possmax: number = nums.reduce((a, b) => a | b, 0);
    const dp: number[][] = new Array(nums.length + 1).fill(null).map(() => new Array(possmax + 1).fill(-1));
    function dfs(index, curr) {
        if ( index === nums.length ) {
            if ( curr === possmax ) {
                return 1;
            }
            return 0;
        }
        if ( dp[index][curr] !== -1 ) {
            return dp[index][curr];
        }
        const nottake = dfs(index + 1, curr);
        const take = dfs(index + 1, curr | nums[index]);
        return dp[index][curr] = take + nottake;
    }
    for ( let i = 0; i < nums.length; i++ ) {
        count += dfs(i + 1, nums[i]);
    }
    return count;
};