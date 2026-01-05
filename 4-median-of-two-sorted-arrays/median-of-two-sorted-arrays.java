class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2,nums1);
        int total = n1 + n2;
        int leftSize = (total + 1) / 2;
        int l = 0;
        int r = n1;
        int l1 = Integer.MIN_VALUE;
        int l2 = Integer.MIN_VALUE;
        int r1 = Integer.MAX_VALUE;
        int r2 = Integer.MAX_VALUE;
        while(l <= r) {
            int cut1 = l + (r - l) /2 ;
            int cut2 = leftSize - cut1;

            l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];

            l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            if(l1 > r2) r = cut1 - 1;
            else if(l2 > r1) l = cut1 + 1;
            else break; 
        }

        if(total % 2 == 1) {
            return Math.max(l1 , l2);
        }
        else {
            return (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0;
        }
    }
}