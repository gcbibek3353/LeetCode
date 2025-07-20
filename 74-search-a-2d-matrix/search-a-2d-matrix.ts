function searchMatrix(matrix: number[][], target: number): boolean {
    let r = matrix.length;
    let c = matrix[0].length;
    let l = 0;
    let h = r * c - 1;

    const getRow = (num: number): number => Math.floor(num / c);
    const getCol = (num: number): number => num % c;

    while (l <= h) {
        let m = Math.floor((l + h) / 2);
        let val = matrix[getRow(m)][getCol(m)]
        if (target === val) return true;
        else if (val < target) l = m + 1;
        else h = m - 1;
    }
    return false;
};