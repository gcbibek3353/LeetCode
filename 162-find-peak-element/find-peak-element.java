class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;
        if (arr[0] > arr[1])
            return 0;
        if (arr[n - 1] > arr[n - 2])
            return n - 1;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == 0)
                mid = 1; // This will only execute when l = 0 and r = 1 , mid = 0 . 
            boolean isIncreasingRight = (arr[mid] > arr[mid - 1]);
            boolean isDecreasingLeft = (arr[mid] > arr[mid + 1]);
            if (isIncreasingRight && isDecreasingLeft)
                return mid;
            else if (isIncreasingRight && !isDecreasingLeft)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}