class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while(left < right) {
            int curArea = (right - left) * Math.min(height[left] , height[right]);
            // System.out.printf("%d , %d , %d \n",left, right , curArea);
            area = Math.max(curArea , area);
            if(height[left] >= height[right]) right --;
            else left ++;
        }
        return area;
    }
}