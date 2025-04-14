function countGoodTriplets(arr: number[], a: number, b: number, c: number): number {
    let count = 0;
    const n = arr.length;

    for(let i = 0; i < n; i ++){
        for(let j = i + 1; j < n; j ++){
            if(Math.abs(arr[i] - arr[j]) <= a){
                for(let k = j + 1; k < n; k ++){
                    if(Math.abs(arr[i] - arr[k]) <= c && Math.abs(arr[j] - arr[k]) <= b){
                        count ++;
                    }
                }
            }
        }
    }

    return count;
}
