function findMinArrowShots(points: number[][]): number {
    points.sort((a,b) => a[0] - b[0]);
    let count = points.length;
    let prev = points[0];
    for(let i = 1; i < points.length; i ++){
        let cur = points[i];
        if(cur[0] <= prev[1]){
            count -= 1;
            prev[0] = cur[0];
            prev[1] = Math.min(cur[1],prev[1]);
        }
        else{
            prev = cur;
        }
    }
    return count;

};