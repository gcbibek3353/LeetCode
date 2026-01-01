class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = 0;
        int ans = -1;
        for(int pile : piles)r = Math.max(r , pile);
        int l = 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            int hr = findHoursGivenRate(piles , m);
            if(hr > h) l = m + 1;
            else {
                ans = m;
                r = m - 1;
            }
        }
        return ans;
    }
    private int findHoursGivenRate(int[] piles , int k) {
        int h = 0;
        for(int i = 0; i < piles.length; i ++) {
            h += Math.ceil((double) piles[i] / k);
        }
        return h;
    }
}