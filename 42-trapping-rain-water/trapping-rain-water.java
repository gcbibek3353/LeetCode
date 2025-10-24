class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int top = st.pop();
                if (st.isEmpty()) break;

                int distance = i - st.peek() - 1;
                int boundedHeight = Math.min(height[i], height[st.peek()]) - height[top];
                water += distance * boundedHeight;
            }
            st.push(i);
        }

        return water;
    }
}
