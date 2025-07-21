function makeFancyString(s: string): string {
    let result: string[] = [];
    
    for (let i = 0; i < s.length; i++) {
        const n = result.length;
        if (n >= 2 && s[i] === result[n - 1] && s[i] === result[n - 2]) {
            continue;
        }
        result.push(s[i]);
    }
    
    return result.join('');
};
