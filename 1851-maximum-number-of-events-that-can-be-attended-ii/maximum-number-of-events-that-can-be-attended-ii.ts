function maxValue(events: number[][], k: number): number {
    // Sort events by their end day
    events.sort((a, b) => a[1] - b[1]);
    const n = events.length;

    // Initialize a DP table with (k+1) rows and n columns filled with 0
    const dp: number[][] = Array.from({ length: k + 1 }, () => new Array(n).fill(0));
    
    // Fill the first row of the DP table for the case of attending one event
    let ans = 0;
    for (let i = 0; i < n; i++) {
        dp[1][i] = Math.max(i > 0 ? dp[1][i - 1] : 0, events[i][2]);
        ans = Math.max(dp[1][i], ans);
    }
    
    // Function to perform binary search to find the last event that does not overlap
    function binarySearch(l: number, r: number, target: number): number {
        let pos = -1;
        while (l <= r) {
            const mid = Math.floor((l + r) / 2);
            if (events[mid][1] < target) {
                pos = mid; // Update position if current event ends before the target starts
                l = mid + 1; // Search in the right half
            } else {
                r = mid - 1; // Search in the left half
            }
        }
        return pos; // Return the position of the last non-overlapping event
    }
    
    // Fill the DP table for cases with more than one event
    for (let i = 0; i < n; i++) {
        const j = binarySearch(0, i - 1, events[i][0]); // Find non-overlapping event index
        for (let l = 2; l <= k; l++) {
            // Calculate the maximum value for attending l events
            dp[l][i] = Math.max(
                (j >= 0 ? dp[l - 1][j] + events[i][2] : 0), // Include the current event
                (i > 0 ? dp[l][i - 1] : 0) // Exclude the current event
            );
            ans = Math.max(dp[l][i], ans); // Update the overall maximum value
        }
    }
    
    return ans; // Return the maximum sum of values
}