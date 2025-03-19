function spiralOrder(matrix: number[][]): number[] {
    const row = matrix.length;
    const col = matrix[0].length;
    const n = row * col;
    let ans = [];

    let count = 0;
    let top = 0;
    let left = 0;
    let bottom = row - 1;
    let right = col - 1;

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
        if (left != right) {

            for (let i = bottom - 1; i >= top + 1; i--) {
                ans.push(matrix[i][left]);
                count++;
            }
        }
        top++;
        bottom--;
        left++;
        right--;
    }
    return ans;
};