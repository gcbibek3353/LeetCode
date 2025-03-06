function findMissingAndRepeatedValues(grid: number[][]): number[] {
    const newMap = new Map<number,number>();
    const ans = [];
    for(let i = 0; i < grid.length; i ++){
        for(let j = 0; j < grid.length; j ++){
            if(newMap.has(grid[i][j])) ans[0] = grid[i][j];
            else newMap.set(grid[i][j],0);
        }
    }
    for(let i = 1; i <= (grid.length ** 2); i ++){
        if(!newMap.has(i)) ans[1] = i;
    }
    return ans;
};