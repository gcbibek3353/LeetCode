function jump(nums: number[]): number {
    let l = 0;
    let r = 0;
    let jumpCount = 0;

    while(r < nums.length - 1){
        let curFarthest = 0;
        for(let i = l; i <= r; i ++) {
            curFarthest = Math.max(curFarthest,i + nums[i]);
        }
        l = r + 1;
        r = curFarthest;
        jumpCount ++;
    }
    return jumpCount;
};