function isIsomorphic(s: string, t: string): boolean {
    if (s.length !== t.length) return false;
    let smp = new Map<string, string>();
    let tmp = new Map<string, string>();

    for (let i = 0; i < s.length; i++) {
        if (smp.has(s.charAt(i))) {
            if (smp.get(s.charAt(i)) !== t.charAt(i)) return false;
        }
        else if (tmp.has(t.charAt(i))) {
            if(tmp.get(t.charAt(i)) !== s.charAt(i)) return false;
        }
        else {
            smp.set(s.charAt(i), t.charAt(i));
            tmp.set(t.charAt(i), s.charAt(i));
        }
    }
    return true;
};