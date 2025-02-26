function summaryRanges(nums: number[]): string[] {
    const ans = [];
    for(let i = 0; i < nums.length; i ++){
        const startIndex = i;
        while(nums[i] + 1 === nums[i + 1]) i ++;
        if(startIndex === i) ans.push(String(nums[i]));
        else ans.push(`${nums[startIndex]}->${nums[i]}`);
    }
    return ans;
};