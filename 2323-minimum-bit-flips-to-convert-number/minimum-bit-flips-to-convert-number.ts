function minBitFlips(start: number, goal: number): number {
  let xorr = start ^ goal;
  let count = 0;
  for(let i = 0; i < 32; i ++){
    let bitMask = 1 << i;
    if((bitMask & xorr) != 0) count ++;
  }
  return count;  
};