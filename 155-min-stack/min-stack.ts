class MinStack {
    arr;
    constructor() {
       this.arr = new Array<number[]>(); 
    }

    push(val: number): void {
        if(this.arr.length !== 0){
            let min = this.arr[this.arr.length - 1][1];
            min = Math.min(min,val);
            this.arr.push([val,min])
        }
        else
        this.arr.push([val,val])
    }

    pop(): void {
        this.arr.pop();
    }

    top(): number {
        return this.arr[this.arr.length - 1][0];
    }

    getMin(): number {
        return this.arr[this.arr.length - 1][1];
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