function isIsomorphic(s: string, t: string): boolean {
    if(s.length !== t.length) return false;
    const sMap = new Map<string,string>();
    const tMap = new Map<string,string>();
   for(let i = 0; i < s.length; i ++){
        const curSchar = s.charAt(i);
        const curTchar = t.charAt(i);

        if(sMap.has(curSchar) && sMap.get(curSchar) !== curTchar) return false;
        if(tMap.has(curTchar) && tMap.get(curTchar) !== curSchar) return false;

        sMap.set(curSchar,curTchar);
        tMap.set(curTchar,curSchar);
   }
    return true;
};