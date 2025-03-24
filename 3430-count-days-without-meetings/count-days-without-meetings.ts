function countDays(days: number, meetings: number[][]): number {
    const n = meetings.length;
    meetings.sort((x, y) => x[0] - y[0]);
    let count = 0;
    let p = 0;
    for (let i = 0; i < n; ++i) {
        if (meetings[i][1] > p) {
            if (meetings[i][0] > p + 1) count += meetings[i][0] - p - 1;
            p = meetings[i][1];
        }
    }
    return count + days - p;
};