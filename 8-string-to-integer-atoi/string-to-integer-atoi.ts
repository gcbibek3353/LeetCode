function myAtoi(s: string): number {
    let nums = new Set<number>([0, 1, 2, 3, 4, 5, 6, 7, 8, 9]);
    s = s.trim();
    let negative = false;
    if (s.charAt(0) === "-") {
        negative = true;
        s = s.substr(1, s.length);
    }else if(s.charAt(0) === "+") s = s.substr(1, s.length);
    let str = "";
    while (s.charAt(0) === "0") s = s.substr(1, s.length);

    for (let i = 0; i < s.length; i++) {
        if (nums.has(parseInt(s.charAt(i)))) str += s.charAt(i);
        else break;
    }
    if (str === "") return 0;

    str = negative ? "-" + str : str;
    let ans = parseInt(str);

    const INT_MIN = -(2 ** 31);
    const INT_MAX = 2 ** 31 - 1;

    if (ans < INT_MIN) return INT_MIN;
    if (ans > INT_MAX) return INT_MAX;

    return ans;

};