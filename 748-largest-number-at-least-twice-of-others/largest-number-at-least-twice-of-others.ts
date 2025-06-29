function dominantIndex(nums: number[]): number {
  let max = -1, secondMax = -1, index = -1;

  nums.forEach((num, i) => {
    if (num > max) {
      secondMax = max;
      max = num;
      index = i;
    } else if (num > secondMax) {
      secondMax = num;
    }
  });

  return max >= 2 * secondMax ? index : -1;
}
