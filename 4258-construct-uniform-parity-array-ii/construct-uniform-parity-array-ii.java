class Solution {
    public boolean uniformArray(int[] nums1) {
        int smallestOdd = Integer.MAX_VALUE;
        int smallestEven = Integer.MAX_VALUE;

        for(int i = 0; i < nums1.length; i ++) {
            if(nums1[i] % 2 == 0) smallestEven = Math.min(smallestEven , nums1[i]);
            else smallestOdd = Math.min(smallestOdd , nums1[i]);
        }
        if(smallestOdd == Integer.MAX_VALUE || smallestEven == Integer.MAX_VALUE) return true;
        if(smallestOdd < smallestEven) return true;
        else return false;
    }
}