class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);

        int left = binarySearchAsc(mountainArr, target, 0, peak);
        if (left != -1) return left;

        return binarySearchDesc(mountainArr, target, peak + 1, mountainArr.length() - 1);
    }

    // Peak finding: only 2 get() calls per loop
    private int findPeak(MountainArray arr) {
        int l = 0, r = arr.length() - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            int midVal = arr.get(mid);
            int rightVal = arr.get(mid + 1);

            if (midVal < rightVal) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    // Ascending binary search: 1 get() per loop
    private int binarySearchAsc(MountainArray arr, int target, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = arr.get(mid);

            if (midVal == target) return mid;
            if (midVal < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    // Descending binary search: 1 get() per loop
    private int binarySearchDesc(MountainArray arr, int target, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = arr.get(mid);

            if (midVal == target) return mid;
            if (midVal > target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}
