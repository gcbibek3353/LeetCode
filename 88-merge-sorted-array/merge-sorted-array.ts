function merge(nums1: number[], m: number, nums2: number[], n: number): void {
    let p1 = m - 1;
    let p2 = n - 1;
    //    for(let i = nums1.length - 1 ; i >= 0; i --){
    //         if(nums2[p2] >= nums1[p1] && p2 >= 0) nums1[i] = nums2[p2 --];
    //         else if(nums2[p2] < nums1[p1] && p1 >= 0) nums1[i] = nums1[p1 --];
    //    }
    let i = nums1.length - 1;
    while (p1 >= 0 && p2 >= 0) {
        if (p2 < 0) return;
        if (p1 < 0) break;
        if (nums2[p2] >= nums1[p1]) nums1[i --] = nums2[p2--];
        else nums1[i --] = nums1[p1--];
    }
    while(p2 >= 0){
        nums1[p2] = nums2[p2 --];
    }
};