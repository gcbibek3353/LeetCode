class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        while(l < r ) {
            int minHeight = Math.min(height[l],height[r]);
            int curArea = minHeight * (r - l);
            ans = Math.max(curArea , ans);
            if(height[l] >= height[r]) r --;
            else l ++;
        }
        return ans;
    }
}