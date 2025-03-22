function spiralOrder(matrix: number[][]): number[] {
    const r = matrix.length;
    const c = matrix[0].length;
    const n = r * c;
    let count = 0;
    const ans = [];
    let top = 0;
    let left = 0;
    let bottom = r - 1;
    let right = c - 1;
    while (count < n) {
        for (let i = left; i <= right; i++) {
            ans.push(matrix[top][i]);
            count++;
        }
        for (let i = top + 1; i <= bottom; i++) {
            ans.push(matrix[i][right]);
            count++;
        }
        if (top != bottom) {
            for (let i = right - 1; i >= left; i--) {
                ans.push(matrix[bottom][i]);
                count++;
            }
        }
        // console.log(ans);
        if (left != right) {
            for (let i = bottom - 1; i >= top + 1; i--) {
                ans.push(matrix[i][left]);
                count++;
            }
        }
        top ++;
        left ++;
        bottom --;
        right --;
    }
    return ans;
};