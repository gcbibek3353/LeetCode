function twoSum(nums: number[], target: number): number[] {
    const mp = new Map<number,number>();
    for(let i = 0; i < nums.length; i ++){
        let x = target - nums[i]; // required compliment
        if(mp.has(x)) return [mp.get(x),i];
        mp.set(nums[i],i);
    }
};