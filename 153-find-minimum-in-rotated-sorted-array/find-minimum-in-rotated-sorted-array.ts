function findMin(nums: number[]): number {
  let left = 0, right = nums.length - 1;

  while (left < right) {
    const mid = Math.floor((left + right) / 2);

    if (nums[mid] > nums[right]) {
      // Min is in the right half
      left = mid + 1;
    } else {
      // Min is at mid or in the left half
      right = mid;
    }
  }

  return nums[left];
}
