class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        // Sorting is important for case like : [[4,7],[1,4]] -> [[1,7]]
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for(int i = 1; i < intervals.length; i ++) {
            int[] lastMerged = ans.get(ans.size() - 1);
            int lastOfFirst = lastMerged[1];
            int firstOfLast = intervals[i][0];
            if(lastOfFirst >= firstOfLast){
            lastMerged[1] = Math.max(intervals[i][1],lastMerged[1]);
            // ans[ans.length - 1][1] = intervals[i][1];
            } 
            else ans.add(intervals[i]);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}