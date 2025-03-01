function addBinary(a: string, b: string): string {
   let ans = "";
   let aP = a.length - 1;
   let bP = b.length - 1;
   let carry = 0;
   while(aP >= 0 || bP >= 0 || carry > 0){
    const aDigit = (aP >= 0) ? parseInt(a[aP]) : 0;
    const bDigit = (bP >= 0 ? parseInt(b[bP]) : 0);
    const sum = aDigit + bDigit + carry;
    ans = (sum % 2) + ans;
    carry = Math.floor(sum / 2);
    aP--;
    bP --;
   }
   return ans;
};