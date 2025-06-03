function merge(nums1: number[], m: number, nums2: number[], n: number): void {
  let p1 = m - 1;
  let p2 = n - 1;
  let i = nums1.length - 1;
  while(p1 >= 0 && p2 >= 0) {
    if(nums2[p2] >= nums1[p1]) nums1[i --] = nums2[p2 --];
    else nums1[i --] = nums1[p1 --];
  }
  if(p1 < 0 && p2 >= 0) while(p2 >= 0) nums1[i --] = nums2[p2 --];
};