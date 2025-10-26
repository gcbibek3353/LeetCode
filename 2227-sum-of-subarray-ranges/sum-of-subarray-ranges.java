class Solution {
    public long subArrayRanges(int[] nums) {
        return subArrayMax(nums) - subArrayMin(nums);
    }

    private long subArrayMax(int[] arr) {
        long ans = 0;
        int[] nge = getNGE(arr);
        int[] pgee = getPGEE(arr);

        for (int i = 0; i < arr.length; i++) {
            long freq = 1L * (nge[i] - i) * (i - pgee[i]);
            ans += freq * arr[i];
        }
        return ans;
    }
   
    private long subArrayMin(int[] arr) {
    long ans = 0;
        int[] nse = getNSE(arr);
        int[] psee = getPSEE(arr);

        for (int i = 0; i < arr.length; i++) {
            long freq = 1L * (nse[i] - i) * (i - psee[i]);
            ans += freq * arr[i];
        }
        return ans;
    }

    private int[] getNGE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    private int[] getPGEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
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

    private int[] getPSEE(int[] arr) {
     int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
}