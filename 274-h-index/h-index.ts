function hIndex(citations: number[]): number {
    let max = Math.max(...citations);
    const citationBucket = new Array(max + 1).fill(0);
    // console.log(citationBucket);
    for(let i = 0; i < citations.length; i ++){
        citationBucket[citations[i]] ++;
    }
    // console.log(citationBucket);
    let cumSum = 0;
    for(let i = citationBucket.length - 1; i >= 0; i --){
        cumSum += citationBucket[i];
        if(cumSum >= i) return i;        
    }
    return -1;
};