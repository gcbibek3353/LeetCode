class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(h < piles.length) return -1;
        int l = 1;
        int r = piles[0];
        for(int i = 1; i < piles.length; i ++) r = Math.max(r , piles[i]);
        int ans = r;
        while(l <= r) {
            int m = l + (r - l) / 2;
            int hrs = 0;
            for(int i = 0; i < piles.length; i ++) {
               hrs += Math.ceil((double) piles[i] / m);
            }
            if(hrs > h) l = m + 1;
            else {
                r = m - 1;
                ans = Math.min(m , ans);
            }
        }
        return ans;
    }
}