function majorityElement(nums: number[]): number[] {
    let ans = [];
    const n = Math.floor(nums.length / 3);
    let mp = new Map<number, number>();

    for (let i = 0; i < nums.length; i++) {
        mp.set(nums[i], (mp.get(nums[i]) || 0) + 1);
    }

    for (let [key, value] of mp.entries()) {
        if (value > n) ans.push(key);
    }

    return ans;

};