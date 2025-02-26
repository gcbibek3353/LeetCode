function isIsomorphic(s: string, t: string): boolean {
    if(s.length !== t.length) return false;
    const smap = new Map<string,string>();
    const tmap = new Map<string,string>();
    for(let i = 0; i < s.length; i ++){
        if(
            (smap.has(s[i]) && smap.get(s[i]) !== t[i]) ||
            (tmap.has(t[i]) && tmap.get(t[i]) !== s[i])
        ) return false;
        else{
            smap.set(s[i],t[i]);
            tmap.set(t[i],s[i]);
        } 
    }
    return true;
};