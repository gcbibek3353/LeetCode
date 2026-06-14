class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            if (i == 0) {
                stack.push(i);
                continue;
            }

            while (stack.size() > 0) {
                int topElmIndex = stack.peek();

                if (temperatures[i] > temperatures[topElmIndex]) {
                    stack.pop();
                    ans[topElmIndex] = i - topElmIndex;
                } else {
                    break;
                }
            }

            stack.push(i);
        }

        while (stack.size() > 0) {
            ans[stack.pop()] = 0;
        }

        return ans;
    }
}