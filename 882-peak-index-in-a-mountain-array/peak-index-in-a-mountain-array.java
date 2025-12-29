class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if(arr.length < 3) return -1;
        int l = 0;
        int r = arr.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(mid == 0) mid = 1;
            boolean isIncreasingRight = (arr[mid] > arr[mid - 1]);
            boolean isDecreasingLeft = (arr[mid] > arr[mid + 1]);
            if(isIncreasingRight && isDecreasingLeft) return mid;
            else if (isIncreasingRight && !isDecreasingLeft) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}