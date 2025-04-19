function isAlphaNumeric(char: string): boolean {
  return /[a-zA-Z0-9]/.test(char); // Check if the character is alphanumeric
}

function isPalindrome(s: string): boolean {
   let l = 0;
   let r = s.length - 1;
   while(l < r){
    while(l < r && !isAlphaNumeric(s.charAt(l))) l ++;
    while(l < r && !isAlphaNumeric(s.charAt(r))) r --;
    if(s.charAt(r).toLowerCase() !== s.charAt(l).toLowerCase()) return false;
    l ++;
    r --;
   }
   return true;
};
