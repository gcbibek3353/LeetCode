function containsNearbyDuplicate(nums: number[], k: number): boolean {
    const numsMap = new Map<number,number>();
    for(let i = 0; i < nums.length; i ++){
        const curNum = nums[i];
    if(numsMap.has(curNum)){
        const diff = Math.abs(i - numsMap.get(curNum));
        if (diff <= k) return true;
    }
    numsMap.set(curNum,i);
    }
    return false;
};