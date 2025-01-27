function letterCombinations(digits: string): string[] {
    let ans = [];
    let digitToChar = {
        "2" : "abc",
        "3" : "def",
        "4" : "ghi",
        "5" : "jkl",
        "6" : "mno",
        "7" : "pqrs",
        "8" : "tuv",
        "9" : "wxyz",
    }
    function helper(curString,index){
        if(curString.length === digits.length){
            ans.push(curString);
            return;
        }
        const chars =  digitToChar[digits[index]];
        for(let char of chars){
            helper(curString + char,index + 1);
        }
    }
    if(digits)
    helper("",0);
    return ans;
};