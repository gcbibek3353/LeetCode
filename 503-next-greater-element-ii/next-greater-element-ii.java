class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n * 2; i ++) {
            // int actualIndex = getActualIndex(i, n);
            while(!stack.isEmpty() && nums[getActualIndex(stack.peek(), n )] < nums[getActualIndex(i,n)]) {
                ans[getActualIndex(stack.pop(),n)] = nums[getActualIndex(i,n)];
            }
            if(i >= n) continue;
            stack.push(i);
        }
        while(!stack.isEmpty()) ans[getActualIndex(stack.pop(),n)] = -1;
        return ans;
    }
    private int getActualIndex(int i , int n){
        return i % n;
    } 
}