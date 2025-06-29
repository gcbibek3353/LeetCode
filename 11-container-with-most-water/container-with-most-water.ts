function maxArea(height: number[]): number {
    let l = 0;
    let r = height.length - 1;
    let maxArea = 0;
    while (l < r) {
        if (height[l] < height[r]) {
            const area = height[l] * (r - l);
            maxArea = Math.max(area, maxArea);
            l++;
        }
        else {
            const area = height[r] * (r - l);
            maxArea = Math.max(area, maxArea);
            r--;
        }
    }
    return maxArea;
};