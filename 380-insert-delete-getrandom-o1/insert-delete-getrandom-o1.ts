class RandomizedSet {
private mp;
private arr;
constructor() {
    this.mp = new Map<number, number>();
    this.arr = new Array();
}

insert(val: number): boolean {
    if (this.mp.has(val)) return false;
    else {
        this.arr.push(val);
        this.mp.set(val, this.arr.length - 1);
        return true;
    }
}

remove(val: number): boolean {
    if (!this.mp.has(val)) return false;
    else {
        let ind1 = this.arr.length - 1;
        let ind2 = this.mp.get(val);
        this.mp.set(this.arr[ind1] , ind2);
        [this.arr[ind1], this.arr[ind2]] = [this.arr[ind2], this.arr[ind1]];
        this.arr.pop();
        this.mp.delete(val);
        return true;
    }
}

getRandom(): number {
    let max = this.arr.length;
    let random = Math.floor(Math.random() * max);
    return this.arr[random];
}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = new RandomizedSet()
 * var param_1 = obj.insert(val)
 * var param_2 = obj.remove(val)
 * var param_3 = obj.getRandom()
 */