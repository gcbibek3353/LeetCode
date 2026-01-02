class Solution {
    public int splitArray(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }

        while (l <= r) {
            int m = l + (r - l) / 2;
            int partitions = getPartition(nums, m);
            if (partitions > k)
                l = m + 1;
            else {
                ans = m;
                r = m - 1;
            }
        }
        return ans;

    }

    private int getPartition(int[] arr, int maxSum) {
         int partitions = 1;
        int curSum = 0;

        for (int num : arr) {
            if (curSum + num > maxSum) {
                partitions++;
                curSum = num;
            } else {
                curSum += num;
            }
        }
        return partitions;
    }
}