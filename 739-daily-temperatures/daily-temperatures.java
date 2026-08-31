class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i ++) {
            int curTemp = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] < curTemp){
                int prevTemp = stack.pop();
                ans[prevTemp] = i - prevTemp;
            }
            stack.push(i);
        }
        return ans;
    }
}