function isAnagram(s: string, t: string): boolean {
    if(s.length !== t.length) return false;
    const sMap = new Map<string,number>();
    const tMap = new Map<string,number>();
    for(let i = 0; i < s.length; i ++){
        if(sMap.has(s[i])) sMap.set(s[i],sMap.get(s[i]) + 1);
        else sMap.set(s[i],1);

        if(tMap.has(t[i])) tMap.set(t[i],tMap.get(t[i]) + 1);
        else tMap.set(t[i],1);
    }
    for(const sChar of sMap){
        console.log(sChar[0],sChar[1],tMap.get(sChar[0]));
        if(sChar[1] !== tMap.get(sChar[0])) return false;
    }
    return true;
};