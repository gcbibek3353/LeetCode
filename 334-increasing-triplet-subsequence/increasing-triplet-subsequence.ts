function increasingTriplet(nums: number[]): boolean {
  let first = Infinity;
  let second = Infinity;

  for (const num of nums) {
    if (num <= first) {
      first = num;           // new smallest
    } else if (num <= second) {
      second = num;          // better middle
    } else {
      // Found a number > second ⇒ triplet exists
      return true;
    }
  }

  return false;
}
