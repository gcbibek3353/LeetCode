function canCompleteCircuit(gas: number[], cost: number[]): number {
    const sum = (arr : number[]) => arr.reduce((num,acc)=>acc + num,0);
    
    if(sum(gas) < sum(cost)) return -1;
    let total = 0;
    let result = 0;
    for(let i = 0; i < gas.length; i ++){
        total += (gas[i] - cost[i]);

        if (total < 0){
            total = 0;
            result = i + 1;
        }
    }
    return result;
};