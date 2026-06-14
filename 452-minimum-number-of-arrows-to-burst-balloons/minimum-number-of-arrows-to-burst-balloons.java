class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b) -> Integer.compare(a[0],b[0]));
        int i = 0;
        int count = 0;
        while(i < points.length){
            int[] curInterval = points[i];
            while(i < points.length - 1 && curInterval[1] >= points[i + 1][0]){
            curInterval[0] = Math.max(curInterval[0],points[i + 1][0]);
            curInterval[1] = Math.min(curInterval[1],points[i + 1][1]);
            i ++;
            } 
            if(i >= points.length - 1 || curInterval[1] < points[i + 1][0])i ++;
            count ++;
        }
        return count;
    }
}