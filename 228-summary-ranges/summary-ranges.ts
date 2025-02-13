function summaryRanges(nums: number[]): string[] {
    const ans = [];
    let i = 0;
    while(i < nums.length){
        const curStartIndex = i;
        while(i < nums.length && ((nums[i] + 1) === nums[i+1])){
            i ++;
        }
        const curEndIndex = i;
        if(curStartIndex === curEndIndex) ans.push(String(nums[curStartIndex]))
        else ans.push(`${nums[curStartIndex]}->${nums[curEndIndex]}`);
        i ++;
    }
    return ans;
};