class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0;
        int curSum = 0;
        double maxAvg = Integer.MIN_VALUE;
        for(int r = 0; r < nums.length; r ++) {
            curSum += nums[r];
            if(r - l + 1 < k) continue;
            else if( r - l + 1 > k) {
                curSum -= nums[l];
                l ++;
            }
            double curAvg = (double)curSum / k;
            maxAvg = Math.max(maxAvg , curAvg);
        }
        return maxAvg;
    }
}