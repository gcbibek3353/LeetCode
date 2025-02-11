function isSubsequence(s: string, t: string): boolean {
    if(s.length <= 0) return true;

    let j = 0;
    for(let i = 0; i < t.length; i ++){
        if(t.charAt(i) === s.charAt(j)){
            j ++;
            if(j === s.length) return true;
        }
    }
    return false;
};