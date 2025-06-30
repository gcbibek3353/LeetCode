function searchRange(nums: number[], target: number): number[] {
  function findFirst(): number {
    let left = 0, right = nums.length - 1;
    let index = -1;
    while (left <= right) {
      const mid = Math.floor((left + right) / 2);
      if (nums[mid] >= target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
      if (nums[mid] === target) index = mid;
    }
    return index;
  }

  function findLast(): number {
    let left = 0, right = nums.length - 1;
    let index = -1;
    while (left <= right) {
      const mid = Math.floor((left + right) / 2);
      if (nums[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
      if (nums[mid] === target) index = mid;
    }
    return index;
  }

  return [findFirst(), findLast()];
}
