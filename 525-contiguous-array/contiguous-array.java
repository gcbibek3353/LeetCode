class Solution {
    public int findMaxLength(int[] nums) {
        int curSum = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0 , -1);
        int maxVal = 0;
        for(int i = 0; i < nums.length; i ++) {
            curSum += (nums[i] == 0) ? -1 : 1;
            if(mp.containsKey(curSum)){
                int length = i - mp.get(curSum);
                maxVal = Math.max(maxVal , length);
            }
            else{
                mp.put(curSum , i);
            }
        }
        return maxVal;

    }
}