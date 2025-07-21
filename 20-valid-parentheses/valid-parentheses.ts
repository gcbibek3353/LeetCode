function isValid(s: string): boolean {
    const map = new Map<string, string>([
        ['(', ')'],
        ['{', '}'],
        ['[', ']']
    ]);

    const stack = new Array<string>();

    for (let char of s) {
        if (map.has(char)) stack.push(char);
        else {
            if (map.get(stack[stack.length - 1]) !== char) return false;
            else stack.pop();
        }
    }

    return stack.length === 0;
};