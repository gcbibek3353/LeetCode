function merge(nums1: number[], m: number, nums2: number[], n: number): void {
    if(n === 0) return;
    let i = m + n - 1;
    let p1 = m - 1;
    let p2 = n - 1;
    if(m === 0) {
        while(p2 >= 0) nums1[i --] = nums2[p2 --];
        return;
    }
    while(i >= 0){
        if(nums1[p1] > nums2[p2]){
            nums1[i --] = nums1[p1 --];
            if(p1 < 0) break;
        }
        else if(nums2[p2] >= nums1[p1]){
            nums1[i --] = nums2[p2 --];
            if(p2 < 0) return;
        }
    }
    while(p2 >= 0) nums1[i --] = nums2[p2 --];
};