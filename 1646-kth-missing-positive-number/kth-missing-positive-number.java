class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            int missing = getNumberOfMissing(arr , m);
            if(missing < k) l = m + 1;
            else {
                r = m - 1;
            }
        }
        if(r == -1) return k;
        else return arr[r] + k - getNumberOfMissing(arr , r);
    }
    private int getNumberOfMissing(int[] arr , int i ) {
        return arr[i] - i - 1;
    }
}