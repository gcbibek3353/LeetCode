class Solution {
    public int missingInteger(int[] nums) {
        if(nums.length == 1) return nums[0] + 1;
        int sum = nums[0];
        int i;
        for(i = 1; i < nums.length; i ++) {
            if(nums[i] - 1 == nums[i - 1]) sum += nums[i];
            else break;
        }
        Set<Integer> st =  new HashSet<>();
        for(i = 0; i < nums.length; i ++) st.add(nums[i]);
        while(st.contains(sum)){
            sum ++;
        }
        return sum;
    }
}