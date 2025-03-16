function maxArea(height: number[]): number {
    let l = 0;
    let r = height.length - 1;
    let maxArea = 0;
    while(l < r){
        if(height[l] < height[r]){
            let curArea = height[l] * (r - l);
            maxArea = Math.max(maxArea,curArea);
            l ++;
        }
        else{
            let curArea = height[r] * (r - l);
            maxArea = Math.max(maxArea,curArea);
            r --;
        }
    }
    return maxArea;
};