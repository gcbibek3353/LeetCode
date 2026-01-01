class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        int ans = 0;
        for(int weight : weights) {
            l = Math.max(l , weight);
            r += weight;
        }
        while(l <= r) {
            int m = l + (r - l) / 2;
            int requiredDays = findDaysGivenWeight(weights , m);
            if(requiredDays > days) l = m + 1;
            else {
                ans = m;
                r = m - 1;
            }
        }
        return ans;
    }
    private int findDaysGivenWeight(int[] weights , int minW) {
        int days = 0;
        int curWeight = 0;
        for(int i = 0; i < weights.length; i ++) {
            if(curWeight + weights[i] <= minW) curWeight += weights[i];
            else {
                curWeight = weights[i];
                days ++;
            }
        }
        days ++;
        return days;
    }
}