function isPalindrome(x: number): boolean {
   if(x < 10 && x >= 0) return true;
   let num = x;
   let rev = 0;
   while(x > 0){
    let rem = x % 10;
    rev = rev * 10 + rem;
    x = Math.floor(x / 10);
   }
   return rev === num;
};