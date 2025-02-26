function isValid(s: string): boolean {
    const stack : string [] = [];
    const map = new Map<string,string>([
        ['(',')'],
        ['{','}'],
        ['[',']']
    ]);
    for(const char of s){
        if(map.has(char)) stack.push(char);
        else {
            if(stack.length === 0) return false;
            const topChar = stack.pop();
            if(map.get(topChar) !== char) return false;
        }
    }
    return stack.length === 0;
};