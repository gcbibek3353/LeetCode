const numberOfWays = (n: number, x: number): number => {
  const numWays = new Array(n + 1).fill(0);
  numWays[0] = 1;

  for (let max = 1; max <= n; max++) {
    const powed = max ** x;
    if (powed > n) break;
    for (let target = n; target >= powed; target--) {
      numWays[target] += numWays[target - powed];
      numWays[target] %= 10 ** 9 + 7;
    }
  }

  return numWays[n];
};