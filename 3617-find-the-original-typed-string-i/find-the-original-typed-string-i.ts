function possibleStringCount(word: string): number {
    if(word.length === 0) return 0;
    let count = 1;
    for(let i = 1; i < word.length; i ++){
        if(word.charAt(i) === word.charAt(i - 1)) count ++;
    }
    return count;
};