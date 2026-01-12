class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for(int i = 0; i < points.length - 1; i ++){
                ans += findDist(points[i] , points[i + 1]);
        }
        return ans;
    }

    private int findDist(int[] p1 , int[] p2) {
        int xDifference = Math.abs(p2[0] - p1[0]);
        int yDifference = Math.abs(p2[1] - p1[1]);
        if(xDifference == yDifference) return xDifference;
        if(xDifference < yDifference) return yDifference;
        else return xDifference;
    }
}