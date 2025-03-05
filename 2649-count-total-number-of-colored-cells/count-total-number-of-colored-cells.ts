function coloredCells(n: number): number {
    if(n < 0)return 0;
    if(n === 1) return 1;
    return coloredCells(n - 1) + 4 * (n - 1);
};