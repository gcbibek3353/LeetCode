function majorityElement(nums: number[]): number[] {
    let cnt1 = 0, cnt2 = 0;
    let el1 = -Infinity, el2 = -Infinity;

    for (let i = 0; i < nums.length; i++) {
        if (cnt1 === 0 && nums[i] !== el2) {
            cnt1++;
            el1 = nums[i];
        }
        else if (cnt2 === 0 && nums[i] !== el1) {
            cnt2++;
            el2 = nums[i];
        }
        else if (nums[i] === el1) cnt1++;
        else if (nums[i] === el2) cnt2++;
        else {
            cnt1--;
            cnt2--;
        }
    }

    cnt1 = 0;
    cnt2 = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === el1) cnt1++;
        if (nums[i] === el2) cnt2++;
    }

    let ans = [];
    let mini = Math.floor(nums.length / 3);
    if (cnt1 > mini) ans.push(el1);
    if (cnt2 > mini) ans.push(el2);

    return ans;
};