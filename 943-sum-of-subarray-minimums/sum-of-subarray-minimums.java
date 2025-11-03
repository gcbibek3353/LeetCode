class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        // Get NSE and PSEE indices
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);

        // Modulo for large results
        int mod = (int) 1e9 + 7;
        int sum = 0;

        // Traverse each element to compute its contribution
        for (int i = 0; i < n; i++) {
            // Count of elements to the left including current
            int left = i - psee[i];

            // Count of elements to the right including current
            int right = nse[i] - i;

            // Total subarrays where arr[i] is the minimum
            long freq = left * right * 1L;

            // Contribution = frequency * value
            int val = (int) ((freq * arr[i]) % mod);

            // Add contribution to sum
            sum = (sum + val) % mod;
        }

        // Return the final sum
        return sum;
    }

    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < arr.length; i ++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                ans[st.pop()] = i;
            }
            st.push(i);
        }
        while(!st.isEmpty()) ans[st.pop()] = n;

        // Return NSE indices
        return ans;
    }

    private int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        // Traverse array from left to right
        for (int i = 0; i < n; i++) {
            // Pop elements greater than current
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            // If stack is empty, PSEE doesn't exist → set to -1
            ans[i] = !st.isEmpty() ? st.peek() : -1;

            // Push current index to stack
            st.push(i);
        }

        // Return PSEE indices
        return ans;
    }

}