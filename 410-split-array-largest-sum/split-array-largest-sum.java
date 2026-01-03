class Solution {
    public int splitArray(int[] nums, int k) {
        int ans = 0;
        int l = 0;
        int r = 0;
        for(int num : nums) {
            l = Math.max(num , l);
            r += num;
        }

        while(l <= r) {
            int m = l + (r - l) / 2;
            int partitions = getPartitions(nums ,m);
            if(partitions > k) l = m + 1;
            else {
                ans = m;
                r = m - 1;
            }
        }
        return ans;
    }
    private int getPartitions(int[] nums , int maxSum) {
        int partitions = 1;
        int curSum = 0;
        for(int num : nums) {
            if(curSum + num > maxSum) {
                partitions ++;
                curSum = num;
            }
            else {
                curSum += num;
            }
        }
        return partitions;
    }
}