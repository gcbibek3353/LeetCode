class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxValue = Integer.MIN_VALUE;
        int curSum = 0;

        for(int i = 0; i < nums.length; i ++) {
            curSum += nums[i];

            if(i - k >= 0) curSum -= nums[i - k];

            if(i >= k - 1){
                double curAvg = (curSum + 0.0) / k;
                maxValue = Math.max(maxValue , curAvg);
            } 

        }
        return maxValue;
    }
}