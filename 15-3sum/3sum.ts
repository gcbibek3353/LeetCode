function threeSum(nums: number[]): number[][] {
    const ans = [];
    const numbers = nums.sort((a, b) => a - b);

    const twoSum = (newNums : number[],target : number, startIndex : number) : void => {
        let endIndex = newNums.length - 1;
        while(startIndex < endIndex){

            if(newNums[startIndex] + newNums[endIndex] === target){
                ans.push([-target,newNums[startIndex], newNums[endIndex]]);
                startIndex ++;
                while(startIndex < endIndex && newNums[startIndex] === newNums[startIndex - 1]) startIndex ++;
                endIndex --;
                while(startIndex < endIndex && newNums[endIndex] === newNums[endIndex + 1]) endIndex --;
            }
            else if (newNums[startIndex] + newNums[endIndex] < target) startIndex ++;
            else endIndex --;
        }
    }

    for(let i = 0; i < numbers.length; i ++){
        if(i === 0 || numbers[i] != numbers[i - 1]){
            console.log('start index is ' + (i + 1))
            twoSum(numbers,-numbers[i],i + 1);
        }
    }
    return ans;
};