function longestConsecutive(nums: number[]): number {
    let maxLen = 0;
    let set = new Set<number>();
    for(let num of nums)set.add(num);
    for(let num of set){
        if(!set.has(num - 1)){
            let curLen = 1;
            while(set.has(num + curLen)) curLen ++;
            maxLen = Math.max(maxLen,curLen);
        }
    }
    return maxLen;
};