function findLucky(arr: number[]): number {
  const numbers: Map<number, number> = new Map();

  arr.forEach(num => numbers.set(num, (numbers.get(num) || 0) + 1));

  return Array.from(numbers.keys()).sort((a, b) => b - a).find(num => num === numbers.get(num)) || -1;
};