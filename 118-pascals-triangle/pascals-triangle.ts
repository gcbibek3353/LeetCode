function generate(numRows: number): number[][] {
    let ans = [];
    for (let i = 1; i <= numRows; i++) {
        let curArr = new Array(i);
        if (i === 1) curArr[0] = 1;
        else {
            for (let j = 0; j < i; j++) {
                if (j === 0) curArr[j] = 1;
                else if (j === i - 1) curArr[j] = 1;
                else {
                    curArr[j] = ans[i - 2][j - 1] + ans[i - 2][j];
                }
            }
        }
        ans.push(curArr);
    }
    return ans;
};