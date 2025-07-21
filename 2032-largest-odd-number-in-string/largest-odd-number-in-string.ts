function largestOddNumber(num: string): string {
    let oddIndex = -1;
    for (let i = 0; i < num.length; i++) {
        if (parseInt(num.charAt(i)) % 2 === 1) oddIndex = i;
    }
    return oddIndex === -1 ? "" : num.substr(0, oddIndex + 1);
};