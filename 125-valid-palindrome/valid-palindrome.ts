function isAlphaNumeric(char: string): boolean {
  return /[a-zA-Z0-9]/.test(char); // Check if the character is alphanumeric
}

// function checkPalindrome(s: string, l: number, r: number): boolean {
//   while (l < r) {
//     // Skip non-alphanumeric characters
//     while (l < r && !isAlphaNumeric(s.charAt(l))) l++;
//     while (l < r && !isAlphaNumeric(s.charAt(r))) r--;

//     // Check for mismatch
//     if (s.charAt(l).toLowerCase() !== s.charAt(r).toLowerCase()) {
//       return false;
//     }

//     l++;
//     r--;
//   }
//   return true;
// }

function isPalindrome(s: string): boolean {
  if (s.length <= 1) return true; // Single characters or empty strings are palindromes
//   return checkPalindrome(s, 0, s.length - 1);
    let l = 0;
    let r = s.length - 1;
     while (l < r) {
//     // Skip non-alphanumeric characters
    while (l < r && !isAlphaNumeric(s.charAt(l))) l++;
    while (l < r && !isAlphaNumeric(s.charAt(r))) r--;

    // Check for mismatch
    if (s.charAt(l).toLowerCase() !== s.charAt(r).toLowerCase()) {
      return false;
    }

    l++;
    r--;
  }
  return true;

}
