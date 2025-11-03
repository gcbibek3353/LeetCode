class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int[] arr = new int[c];
        Arrays.fill(arr , 0);
        int maxArea = 0;

        for(int i = 0; i < r; i ++) {
            for(int j = 0; j < c; j ++) {
                if(matrix[i][j] == '0') arr[j] = 0;
                else arr[j] = arr[j] + 1;
            }
            for(int k = 0; k < arr.length; k ++) System.out.print(arr[k]);
            int curArea = largestRectangleArea(arr);
            maxArea = Math.max(curArea,maxArea);
        }
        return maxArea;
    }

     public int largestRectangleArea(int[] heights) {
        int[] NSE = getNSE(heights);
        int[] PSE = getPSE(heights);
        int maxArea = 0;
        for(int i = 0; i < heights.length; i ++) {
            int width = NSE[i] - PSE[i] - 1;
            int curArea = width * heights[i];
            maxArea = Math.max(maxArea , curArea);
        }
        return maxArea;
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