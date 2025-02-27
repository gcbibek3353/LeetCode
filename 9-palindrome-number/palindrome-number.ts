function isPalindrome(x: number): boolean {
    if(x < 0) return false;
    if(x > 0 && x < 10) return true;
    let num = x;
    let rev = 0;
    while(num > 0){
        const digit = num % 10;
        rev = rev * 10 + digit;
        num = Math.floor(num/10);
    }
    return rev === x;
};