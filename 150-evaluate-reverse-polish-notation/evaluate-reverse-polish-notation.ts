function evalRPN(tokens: string[]): number {
    const operations = new Map<string, (a: number, b: number) => number>([
        ['+', (a: number, b: number) => a + b],
        ['-', (a: number, b: number) => a - b],
        ['*', (a: number, b: number) => a * b],
        ['/', (a: number, b: number) => Math.trunc(a / b)],
    ])
    const stack = new Array<string>();
    for(let char of tokens){
        if(operations.has(char)){
            const a = parseInt(stack.pop());
            const b = parseInt(stack.pop());
            const ans = operations.get(char)!(b,a);
            stack.push(ans.toString());
        }
        else stack.push(char);
    }
    return parseInt(stack.pop());
};