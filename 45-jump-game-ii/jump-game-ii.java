class Solution {
    public int jump(int[] nums) {
        int l = 0;
        int r = 0;
        int count = 0;
        while ( r < nums.length - 1) {
            int curFar = 0;
            for(int i = l; i <= r ; i ++) {
                curFar = Math.max(curFar , i + nums[i]);
            }
            l = r + 1;
            r = curFar;
            count ++;
        }
        return count;
    }
}