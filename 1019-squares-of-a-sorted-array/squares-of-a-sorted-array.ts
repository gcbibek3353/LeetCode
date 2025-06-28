function sortedSquares(nums: number[]): number[] {
    let ans = [];
    let l = 0;
    let r = nums.length - 1;
    while(l <= r){
        if(sqr(nums[l]) >= sqr(nums[r])) ans.unshift(sqr(nums[l ++]));
        else ans.unshift(sqr(nums[r --]));
    }
    return ans;
};

const sqr = (n : number) : number => (n * n);