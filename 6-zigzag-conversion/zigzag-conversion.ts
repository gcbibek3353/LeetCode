function convert(s: string, numRows: number): string {
    let curRow = 0;
    let raising = true;
    let strArr = new Array<string>(numRows).fill("");
    console.log(strArr);
    for(let i = 0; i < s.length; i ++){
        strArr[curRow] += s.charAt(i);
        if(raising && curRow < numRows - 1) curRow += 1;
        else if(raising === false && curRow > 0) curRow -= 1;
        if(curRow === 0) raising = true;
        if(curRow === numRows - 1) raising = false;
    }
    return strArr.join("");
};