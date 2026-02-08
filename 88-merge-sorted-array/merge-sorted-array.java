class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = nums1.length - 1;
        m = m -1;
        n = n - 1;
        while(l >= 0) {
            if(m < 0 || n < 0) break;
            if(nums1[m] < nums2[n]) {
                nums1[l --] = nums2[n --];
                continue;
            }
            else {
                nums1[l --] = nums1[m --];
                continue;
            }
        }
        while(m >= 0) nums1[l --] = nums1[m --];
        while(n >= 0) nums1[l --] = nums2[n --];
    }
}