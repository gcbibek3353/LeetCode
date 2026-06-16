class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i ++) {
            while(stack.size() > 0){
                int topElmIndex = stack.peek();
                if(temperatures[topElmIndex] < temperatures[i]){
                    ans[topElmIndex] = i - topElmIndex;
                    stack.pop();
                }
                else break;
            }
            stack.push(i);
        }
        while(stack.size() > 0){
            int topElmIndex = stack.pop();
            ans[topElmIndex] = 0;
        }
        return ans;
    }
}