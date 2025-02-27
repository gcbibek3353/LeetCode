function hammingWeight(n: number): number {
  let count = 0;
  for(let i = 0; i < 32; i ++){
    const bitMask = 1 << i;
    const curBit = ((n & bitMask) === 0) ? 0 : 1;
    count += curBit;
  }  
  return count;
};