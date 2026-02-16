class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ans.add(intervals[0]);
        for(int i = 1; i < intervals.length; i ++){
            int[] lastInterval = ans.get(ans.size() - 1);
            int lastOfFirst = lastInterval[1];
            int firstOfLast = intervals[i][0];
            if(lastOfFirst >= firstOfLast){
                lastInterval[1] = Math.max(lastInterval[1],intervals[i][1]);
            }
            else {
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][]);

    }
}