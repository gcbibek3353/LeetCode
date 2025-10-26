class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nse = getNSE(heights);
        int[] pse = getPSE(heights);
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            int curArea = (nse[i] - pse[i] - 1) * heights[i];
            area = Math.max(area, curArea);
        }
        return area;
    }

    private int[] getNSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    private int[] getPSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

}