function isSubsequence(s: string, t: string): boolean {
   if(s.length > t.length) return false;
   let sP = 0;
   for(let i = 0; i < t.length; i ++){
    if(t.charAt(i) === s[sP]) sP ++;
   }
   return (sP === s.length)
};