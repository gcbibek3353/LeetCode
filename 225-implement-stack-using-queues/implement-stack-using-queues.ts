class MyStack {
    q1;
    q2;
    constructor() {
        this.q1 = new Array();
        this.q2 = new Array();
    }

    push(x: number): void {
        for (let i = 0; i < this.q1.length; i++) this.q2[i] = this.q1[i];
        this.q1[0] = x;
        for (let i = 0; i < this.q2.length; i++) this.q1[i + 1] = this.q2[i];
    }

    pop(): number {
       return this.q1.shift();
    }

    top(): number {
        return this.q1[0];
    }

    empty(): boolean {
        return (this.q1.length === 0);
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = new MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */