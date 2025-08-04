class MinStack {
    ds;
    constructor() {
        this.ds = new Array<number[]>();
    }

    push(val: number): void {
        let minVal = (this.ds.length === 0) ? val : Math.min(val, this.ds[this.ds.length - 1][1]);
        this.ds.push([val, minVal]);
    }

    pop(): void {
        if (this.ds.length === 0) return;
        this.ds.pop();
    }

    top(): number {
        if(this.ds.length === 0) return -1;
        return this.ds[this.ds.length - 1][0];
    }

    getMin(): number {
         if(this.ds.length === 0) return -1;
        return this.ds[this.ds.length - 1][1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */