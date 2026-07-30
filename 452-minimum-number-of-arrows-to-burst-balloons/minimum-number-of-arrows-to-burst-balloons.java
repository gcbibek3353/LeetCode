class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b) -> Integer.compare(a[0], b[0]));
        int mergeCount = 0;
        for(int i = 0; i < points.length - 1; i ++) {
            int[] curInterval = points[i];
            int[] nextInterval = points[i + 1];
            if(curInterval[1] >= nextInterval[0]){
                mergeCount ++;
                nextInterval[0] = Math.max(curInterval[0], nextInterval[0]);
                nextInterval[1] = Math.min(curInterval[1], nextInterval[1]);
            }
        }
        return points.length - mergeCount;
    }
}