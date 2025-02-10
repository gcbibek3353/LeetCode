function lengthOfLastWord(s: string): number {
    // let words = s.trim().split(' ');
    // return words[words.length - 1].length;
    let end = s.length - 1;
    let length = 0;
    while(end > 0 && s[end] === " ") end --;
    while(end >= 0 && s[end] !== " "){
        end --;
        length ++;
    }
    return length;
};