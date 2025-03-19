function lengthOfLongestSubstring(s: string): number {
    let l = 0;
    const mp = new Map<string,number>();
    let curMax = 0;
    for(let r = 0; r < s.length; r ++ ) {
        if(mp.has(s.charAt(r))) l = Math.max(l,mp.get(s.charAt(r)) + 1);
        mp.set(s.charAt(r),r);
        // console.log(r , l);
        curMax = Math.max(curMax,r - l + 1 );
    }
    return curMax;
};