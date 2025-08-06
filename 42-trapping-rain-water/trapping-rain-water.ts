function trap(height: number[]): number {
    let l = 0;
    let r = height.length - 1;
    let lMax = height[0];
    let rMax = height[height.length - 1];

    let count = 0;

    while (l < r) {
        if (rMax <= lMax) {
            count += rMax - height[r--];
            rMax = Math.max(rMax, height[r]);
        }
        else {
            count += lMax - height[l++];
            lMax = Math.max(lMax, height[l]);
        }
    }

    return count;
};