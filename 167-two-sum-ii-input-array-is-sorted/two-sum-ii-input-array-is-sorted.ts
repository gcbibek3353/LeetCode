function twoSum(numbers: number[], target: number): number[] {
    let l = 0;
    let r = numbers.length - 1;
    while(l < r){
        const curSum = numbers[l] + numbers[r];
        if(curSum < target) l ++;
        else if (curSum > target) r --;
        else {
            let ans = [l + 1, r + 1];
            return ans;
        }
    }
};