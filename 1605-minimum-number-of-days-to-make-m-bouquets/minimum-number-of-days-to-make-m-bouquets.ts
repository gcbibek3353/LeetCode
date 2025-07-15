function minDays(bloomDay: number[], m: number, k: number): number {
  const n = bloomDay.length

  // Not enough flowers to form the required bouquets
  if (n < m * k) return -1

  // Helper function to check if we can form m bouquets in given days
  function canMakeBouquets(days: number): boolean {
    let bouquets = 0
    let flowers = 0

    for (let i = 0; i < n; i++) {
      // Checks if the flower at `ith` index has bloomed
      if (bloomDay[i] <= days) {
        flowers++
        // If we have `k` flowers bloomed, we can make a bouquet
        if (flowers == k) {
          bouquets++
          flowers = 0
        }
      }
      // Reset the count if the flower hasn't bloomed
      else {
        flowers = 0
      }

      // No need to check further if we already have enough bouquets
      if (bouquets >= m) {
        return true
      }
    }

    return bouquets >= m
  }

  // Initialize the limits of the binary search
  let left = Math.min(...bloomDay)
  let right = Math.max(...bloomDay)

  while (left < right) {
    const mid = Math.floor((left + right) / 2)

    // If we can make `m` bouquets in `mid` days, try for a smaller number of days
    if (canMakeBouquets(mid)) {
      right = mid
    }
    // Otherwise, try for a larger number of days
    else {
      left = mid + 1
    }
  }

  return left
}