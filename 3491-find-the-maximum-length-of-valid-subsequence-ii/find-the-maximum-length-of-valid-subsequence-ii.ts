
function maximumLength(nums: number[], k: number): number {
    let p: number[][] = Array.from({ length: k }, () => []);
    nums.forEach((num, i) => {
        p[num % k].push(i);
    });
    p.sort((a, b) => b.length - a.length);
    let res: number = Math.max(2, p[0].length);
    for (let i = 0; i < p.length; i++) {
        for (let j = i + 1; j < p.length && (p[i].length + p[j].length) > res; j++) {
            let a = p[j]; 
            let b = p[i]; 
            let res_ab: number = 0;
            if (b[0] < a[0]) {
                res_ab++;
            }
            if (b[b.length - 1] < a[a.length - 1]) {
                res_ab++;
            }
            for (let x = 0, y = 0; x < b.length && y < a.length; x++) {
                if (a[y] < b[x]) {
                    res_ab += 2;
                }
                while (y < a.length && a[y] < b[x]) {
                    y++;
                }
            }
            res = Math.max(res, res_ab);
        }
    }
    return res;
}